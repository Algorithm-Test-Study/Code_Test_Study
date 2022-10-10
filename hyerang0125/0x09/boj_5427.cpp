#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
int tc, w, h;
string board[1002];
int dist[1002][1002];
int fire_dist[1002][1002];
int dx[4] = {1, 0, 0, -1};
int dy[4] = {0, 1, -1, 0};

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> tc;
    while(tc--){
        queue<pair<int, int>> fire;
        queue<pair<int, int>> q;
        bool flag = false;

        memset(dist, -1, sizeof(dist));
        memset(fire_dist, -1, sizeof(fire_dist));

        cin >> w >> h;
        for(int i=0; i<h; i++){
            cin >> board[i];
            for(int j=0; j<w; j++){
                if(board[i][j] == '@'){
                    q.push(make_pair(i, j));
                    dist[i][j] = 0;
                } 
                if(board[i][j] == '*'){
                    fire.push(make_pair(i,j));
                    fire_dist[i][j] = 0;
                }
            }
        }

        while(!fire.empty()){
            auto cur = fire.front(); fire.pop();
            for(int dir=0; dir<4; dir++){
                int nx = cur.X + dx[dir];
                int ny = cur.Y + dy[dir];
                if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                if(fire_dist[nx][ny] != -1 || board[nx][ny] == '#') continue;
                fire_dist[nx][ny] = fire_dist[cur.X][cur.Y] + 1;
                fire.push(make_pair(nx, ny));
            }
        }
        
        while(!q.empty()){
            auto cur = q.front(); q.pop();
            for(int dir=0; dir<4; dir++){
                int nx = cur.X + dx[dir];
                int ny = cur.Y + dy[dir];
                if(nx < 0 || nx >= h || ny < 0 || ny >= w){
                    cout << dist[cur.X][cur.Y] + 1 << '\n';
                    flag = true; break;
                }
                if(board[nx][ny] == '#' || board[nx][ny] == '*') continue;
                if(dist[nx][ny] != -1) continue;
                if((dist[cur.X][cur.Y] + 1 >= fire_dist[nx][ny]) && fire_dist[nx][ny] != -1) continue;
                dist[nx][ny] = dist[cur.X][cur.Y] + 1;
                q.push(make_pair(nx, ny));
            }
            if(flag) break;
        }
        if(!flag) cout << "IMPOSSIBLE\n";
    }

    return 0;
}