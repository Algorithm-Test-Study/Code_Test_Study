#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
int board[1000][1000];
int dist[1000][1000];
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
int n,m;
queue<pair<int,int>> q;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> m >> n;
    for(int i=0; i<n; i++)  fill(dist[i], dist[i]+m, -1);
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            cin >> board[i][j];
            if(board[i][j] == 1){
                q.push({i,j});
                dist[i][j] = 0;
            }
        }
    }
    int max = 0;
    while(!q.empty()){
        pair<int,int> cur = q.front(); q.pop();
        for(int dir=0; dir<4; dir++){
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m)  continue;
            if(dist[nx][ny] >= 0 || board[nx][ny] != 0)   continue;
            dist[nx][ny] = dist[cur.X][cur.Y] + 1;
            if(dist[nx][ny] > max)  //find max
                max = dist[nx][ny];
            q.push({nx,ny});
        }
    }
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            if(board[i][j] == 0 && dist[i][j] == -1){
                cout << "-1";
                return 0;
            }
        }
    }
    cout << max;
    return 0;
}
