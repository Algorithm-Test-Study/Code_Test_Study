#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
int board[1002][1002];
int dist[1002][1002];
int n, m, day;
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> m >> n;
    queue<pair<int, int>> q;
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            cin >> board[i][j];
            if (board[i][j] == 1) q.push({i, j});
            if (board[i][j] == 0) dist[i][j] = -1;
        }
    }

    while(!q.empty()){
        pair<int, int> cur = q.front(); q.pop();
        for(int dir=0; dir<4; dir++){
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if(dist[nx][ny] >= 0) continue;
            dist[nx][ny] = dist[cur.X][cur.Y] + 1;
            q.push(make_pair(nx, ny));
        }
    }

    day = 0;
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            if(dist[i][j] == -1){
                cout << -1;
                return 0;
            }
            day = max(day, dist[i][j]); 
        }
    }

    cout << day;

    return 0;
}