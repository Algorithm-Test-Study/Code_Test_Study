#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int tc, n, m, area, x, y;
    int dx[4] = {1, 0, -1, 0};
    int dy[4] = {0, 1, 0, -1};

    cin >> tc;
    while(tc--){
        int cnt = 0;
        int board[52][52] = {0, };
        int visit[52][52] = {0, };

        cin >> n >> m >> area;
        for(int i=0; i<area; i++){
            cin >> x >> y;
            board[x][y] = 1;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] != 1 || visit[i][j]) continue;
                cnt++;
                queue<pair<int, int>> q;
                q.push(make_pair(i, j)); visit[i][j] = 1;
                while(!q.empty()){
                    pair<int, int> cur = q.front(); q.pop();
                    for(int dir=0; dir<4; dir++){
                        int nx = cur.first + dx[dir];
                        int ny = cur.second + dy[dir];
                        if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if(board[nx][ny] != 1 || visit[nx][ny]) continue;
                        q.push(make_pair(nx, ny)); visit[nx][ny] = 1;
                    }
                }
            }
        }
        cout << cnt << '\n';
    }

    return 0;
}