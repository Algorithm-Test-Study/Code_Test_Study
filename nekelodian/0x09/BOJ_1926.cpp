#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
int pic[500][500];
bool vis[500][500];
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    queue<pair<int,int>> q;
    int n, m;
    
    cin >> n >> m;
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            cin >> pic[i][j];
        }
    }
    
    int cnt = 0, mx = 0;
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            //if(pic[i][j] == 0 || vis[i][j] == 1)    continue;
            if(pic[i][j] == 1 && vis[i][j] == 0){
                cnt++;
                q.push({i,j});
                vis[i][j] = 1;
                int tmp = 0;
                while(!q.empty()){
                    tmp++;
                    pair<int,int> cur = q.front(); q.pop();
                    for(int dir=0; dir<4; dir++){
                        int nx = cur.X + dx[dir];
                        int ny = cur.Y + dy[dir];
                        if(nx < 0 || nx >= n || ny <0 || ny >= m)   continue;
                        if(vis[nx][ny] == 1 || pic[nx][ny] != 1)   continue;
                        vis[nx][ny] = 1;
                        q.push({nx, ny});
                    }
                }
                mx = max(mx, tmp);
            }
        }
    }
    cout << cnt << '\n' << mx;
    return 0;
}
