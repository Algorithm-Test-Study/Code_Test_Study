#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
int tc, l, result;
int dist[305][305];
int dx[8] = {1, 2, -1, -2, 1, 2, -1, -2};
int dy[8] = {2, 1, 2, 1, -2, -1, -2, -1};

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> tc;
    while(tc--){
        bool flag = false;
        pair<int, int> start, done;
        queue<pair<int, int>> q;
        memset(dist, -1, sizeof(dist));

        cin >> l;
        cin >> start.X >> start.Y;
        cin >> done.X >> done.Y;

        dist[start.X][start.Y] = 0;
        q.push(make_pair(start.X, start.Y));

        result = 0;
        while(!q.empty()){
            auto cur = q.front(); q.pop();
            for(int dir=0; dir<8; dir++){
                int nx = cur.X + dx[dir];
                int ny = cur.Y + dy[dir];
                if(cur.X == done.X && cur.Y == done.Y){
                    cout << dist[cur.X][cur.Y] << '\n';
                    flag = true; break;
                }
                if(nx < 0 || nx >= l || ny < 0 || ny >= l) continue;
                if(dist[nx][ny] >= 0) continue;
                dist[nx][ny] = dist[cur.X][cur.Y] + 1;
                q.push(make_pair(nx, ny));
            }
            if(flag) break;
        }
    }

    return 0;
}