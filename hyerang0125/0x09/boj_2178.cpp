#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, min;
    string board[102];
    int visit[502][502];
    int dx[4] = {1, 0, -1, 0};
    int dy[4] = {0, 1, 0, -1};

    cin >> n >> m;
    for(int i=0; i<n; i++)
        cin >> board[i];

    for(int i=0; i<n; i++) fill(visit[i], visit[i]+m, -1);
    queue<pair<int, int>> q;
    q.push(make_pair(0, 0)); visit[0][0] = 0;
    while(!q.empty()){
        pair<int, int> cur = q.front(); q.pop();
        for(int dir=0; dir<4; dir++){
            int nx = cur.first + dx[dir];
            int ny = cur.second + dy[dir];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if(visit[nx][ny] >= 0 || board[nx][ny] != '1') continue;
            visit[nx][ny] = visit[cur.first][cur.second] + 1;
            q.push(make_pair(nx, ny));
        }
    }

    cout << visit[n-1][m-1] + 1;

    return 0;
}