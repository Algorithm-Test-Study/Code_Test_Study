#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
string board[1004];
int dist[104][104];
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n;
    cin >> n;
    for(int i=0; i<n; i++){
        cin >> board[i];
    }
    int cnt = 0, flag = 0;
    queue<pair<int,int>> q;
    //R
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            if(board[i][j] != 'R' || dist[i][j] == 1)  continue;
            cnt++;
            dist[i][j] = 1;
            q.push({i,j});
            while(!q.empty()){
                pair<int,int> cur = q.front();  q.pop();
                for(int dir=0; dir<4; dir++){
                    int nx = cur.X + dx[dir];
                    int ny = cur.Y + dy[dir];
                    if(nx <0 || ny < 0 || nx >= n || ny >= n)   continue;
                    if(dist[nx][ny] || board[nx][ny] != 'R')    continue;
                    dist[nx][ny] = 1;
                    q.push({nx,ny});
                }
            }
        }
    }
    fill(&dist[0][0], &dist[n-1][n], 0);
    //G
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            if(board[i][j] != 'G' || dist[i][j] == 1)  continue;
            cnt++;
            dist[i][j] = 1;
            q.push({i,j});
            while(!q.empty()){
                pair<int,int> cur = q.front();  q.pop();
                for(int dir=0; dir<4; dir++){
                    int nx = cur.X + dx[dir];
                    int ny = cur.Y + dy[dir];
                    if(nx <0 || ny < 0 || nx >= n || ny >= n)   continue;
                    if(dist[nx][ny] || board[nx][ny] != 'G')    continue;
                    dist[nx][ny] = 1;
                    q.push({nx,ny});
                }
            }
        }
    }
    fill(&dist[0][0], &dist[n-1][n], 0);
    //B
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            if(board[i][j] != 'B' || dist[i][j] == 1)  continue;
            cnt++;
            dist[i][j] = 1;
            q.push({i,j});
            while(!q.empty()){
                pair<int,int> cur = q.front();  q.pop();
                for(int dir=0; dir<4; dir++){
                    int nx = cur.X + dx[dir];
                    int ny = cur.Y + dy[dir];
                    if(nx <0 || ny < 0 || nx >= n || ny >= n)   continue;
                    if(dist[nx][ny] || board[nx][ny] != 'B')    continue;
                    dist[nx][ny] = 1;
                    q.push({nx,ny});
                }
            }
        }
    }
    fill(&dist[0][0], &dist[n-1][n], 0);
    cout << cnt << ' ';
    //RG
    cnt = 0;
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            if(board[i][j] == 'B' || dist[i][j] == 1)  continue;
            cnt++;
            dist[i][j] = 1;
            q.push({i,j});
            while(!q.empty()){
                pair<int,int> cur = q.front();  q.pop();
                for(int dir=0; dir<4; dir++){
                    int nx = cur.X + dx[dir];
                    int ny = cur.Y + dy[dir];
                    if(nx <0 || ny < 0 || nx >= n || ny >= n)   continue;
                    if(dist[nx][ny] || board[nx][ny] == 'B')    continue;
                    dist[nx][ny] = 1;
                    q.push({nx,ny});
                }
            }
        }
    }
    //B
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            if(board[i][j] != 'B' || dist[i][j] == 1)  continue;
            cnt++;
            dist[i][j] = 1;
            q.push({i,j});
            while(!q.empty()){
                pair<int,int> cur = q.front();  q.pop();
                for(int dir=0; dir<4; dir++){
                    int nx = cur.X + dx[dir];
                    int ny = cur.Y + dy[dir];
                    if(nx <0 || ny < 0 || nx >= n || ny >= n)   continue;
                    if(dist[nx][ny] || board[nx][ny] != 'B')    continue;
                    dist[nx][ny] = 1;
                    q.push({nx,ny});
                }
            }
        }
    }
    cout << cnt;
    return 0;
}
