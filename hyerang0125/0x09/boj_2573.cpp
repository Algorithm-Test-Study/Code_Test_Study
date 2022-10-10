#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
int n, m, years, temp;
int board[303][303];
int vis[303][303];
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

void melting(){
    int zero[303][303] = {0, };
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            if(board[i][j] == 0) continue;
            for(int dir=0; dir<4; dir++){
                int nx = i + dx[dir];
                int ny = j + dy[dir];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(board[nx][ny] == 0) zero[i][j]++;
            }
        }
    }
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            board[i][j] = max(0, board[i][j] - zero[i][j]);
        }
    }
}

int status(){
    int x, y;
    int cnt1, cnt2;

    cnt1 = 0;
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            if(board[i][j]){
                x = i, y = j;
                cnt1++;
            }
        }
    }
    if(cnt1 == 0) return 0;

    cnt2 = 0;
    queue<pair<int, int>> q;
    vis[x][y] = 1;
    q.push(make_pair(x, y));
    while(!q.empty()){
        auto cur = q.front(); q.pop();
        cnt2++;
        for(int dir=0; dir<4; dir++){
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if(vis[nx][ny] == 1 || board[nx][ny] <= 0) continue;
            vis[nx][ny] = 1;
            q.push(make_pair(nx, ny));
        }
    }
    if(cnt1 == cnt2) return 1;
    return 2;
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> m;
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            cin >> board[i][j];
        }
    }

    years = 0;
    while(true){
        years++;
        melting();
        memset(vis, 0, sizeof(vis));
        int check = status();
        if(check == 0){
            years = 0; break;
        }
        else if(check == 1) continue;
        else break;
    }
    cout << years;

    return 0;
}