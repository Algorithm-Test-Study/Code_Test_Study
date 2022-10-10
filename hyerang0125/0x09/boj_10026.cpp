#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, rgb, rg;
    int dx[4] = {1, 0, -1, 0};
    int dy[4] = {0, 1, 0, -1};
    string board[102];
    int visit1[102][102] = {0, };
    int visit2[102][102] = {0, };
    
    cin >> n;
    for(int i=0; i<n; i++)
        cin >> board[i];
    
    rgb = 0;
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            if(visit1[i][j]) continue;
            rgb++;
            queue<pair<int, int>> q;
            q.push(make_pair(i, j)); visit1[i][j] = 1;
            while(!q.empty()){
                pair<int, int> cur = q.front(); q.pop();
                for(int dir=0; dir<4; dir++){
                    int nx = cur.first + dx[dir];
                    int ny = cur.second + dy[dir];
                    if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    if(visit1[nx][ny] || board[i][j] != board[nx][ny]) continue;
                    q.push(make_pair(nx, ny)); visit1[nx][ny] = 1;
                }
            }
        }
    }

    for(int i=0; i<n; i++)
        for(int j=0; j<n; j++)
            if(board[i][j] == 'G') board[i][j] = 'R';
    
    rg = 0;
    for (int i = 0; i < n; i++){
        for (int j = 0; j < n; j++){
            if (visit2[i][j]) continue;
            rg++;
            queue<pair<int, int>> q;
            q.push(make_pair(i, j));
            visit2[i][j] = 1;
            while (!q.empty()){
                pair<int, int> cur = q.front();
                q.pop();
                for (int dir = 0; dir < 4; dir++){
                    int nx = cur.first + dx[dir];
                    int ny = cur.second + dy[dir];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    if (visit2[nx][ny] || board[i][j] != board[nx][ny]) continue;
                    q.push(make_pair(nx, ny));
                    visit2[nx][ny] = 1;
                }
            }
        }
    }

    cout << rgb << " " << rg;

    return 0;
}