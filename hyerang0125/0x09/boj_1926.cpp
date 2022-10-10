#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, max, cnt;
    int board[502][502];
    int visit[502][502];
    int dx[4] = {1, 0, -1, 0};
    int dy[4] = {0, 1, 0, -1};

    cin >> n >> m;
    for(int i=0; i<n; i++)
        for(int j=0; j<m; j++)
            cin >> board[i][j];

    max = cnt = 0;
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            if(visit[i][j] || board[i][j] == 0) continue;
            cnt++;
            queue<pair<int, int>> q;
            q.push(make_pair(i, j)); visit[i][j] = 1;
            int area = 0;
            while(!q.empty()){
                area++;
                pair<int, int> cur = q.front(); q.pop();
                for(int dir=0; dir<4; dir++){
                    int nx = cur.first + dx[dir];
                    int ny = cur.second + dy[dir];
                    if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if(visit[nx][ny] || board[nx][ny] != 1) continue;
                    visit[nx][ny] = 1;
                    q.push(make_pair(nx, ny));
                }
            }
            if(area > max) max = area;
        }
    }

    cout << cnt << '\n' << max;

    return 0;
}