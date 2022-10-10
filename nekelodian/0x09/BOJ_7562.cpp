#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
int dx[8] = {2,2,1,1,-2,-2,-1,-1};
int dy[8] = {1,-1,2,-2,1,-1,2,-2};

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int T;
    cin >> T;
    for(int tc=0; tc<T; tc++){
        int board[304][304] = {0};
        int dist[304][304] = {0};
        int l;
        int x, y;
        cin >> l;
        cin >> x >> y;
        queue<pair<int,int>> q;
        q.push({x,y});
        board[x][y] = 1;
        dist[x][y] = 1;
        cin >> x >> y;
        
        while(!q.empty()){
            pair<int,int> cur = q.front(); q.pop();
            for(int dir=0; dir<8; dir++){
                if(cur.X == x && cur.Y == y){
                    cout << dist[cur.X][cur.Y]-1 << '\n';
                    break;
                }
                int nx = cur.X + dx[dir];
                int ny = cur.Y + dy[dir];
                if(nx < 0 || nx >=l || ny <0 || ny >= l)    continue;
                if(dist[nx][ny] > 0)    continue;
                q.push({nx,ny});
                dist[nx][ny] = dist[cur.X][cur.Y]+1;
            }
        }
        while(!q.empty())
            q.pop();
    }
    return 0;
}
