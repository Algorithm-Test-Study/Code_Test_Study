#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int T;
    cin >> T;
    for(int tc=0; tc<T; tc++){
        int board[54][54] = {0};
        int vis[54][54] = {0};
        int n,m,k;
        cin >> m >> n >> k;
        for(int i=0; i<k; i++){
            int x, y;
            cin >> x >> y;
            board[y][x] = 1;
        }
        queue<pair<int,int>> q;
        int cnt = 0;    //answer
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == 0 || vis[i][j] == 1)    continue;
                q.push({i,j});
                vis[i][j] = 1;
                int flag = 0;
                while(!q.empty()){
                    flag = 1;
                    pair<int,int> cur = q.front(); q.pop();
                    for(int dir=0; dir<4; dir++){
                        int nx = cur.X + dx[dir];
                        int ny = cur.Y + dy[dir];
                        if(nx < 0 || nx >= n || ny < 0 || ny >= m)  continue;
                        if(vis[nx][ny] == 1 || board[nx][ny] != 1)    continue;
                        vis[nx][ny] = 1;
                        q.push({nx,ny});
                    }
                }
                if(flag)    cnt++;
            }
        }
        cout << cnt << '\n';
        while(!q.empty())
            q.pop();
    }
    return 0;
}
