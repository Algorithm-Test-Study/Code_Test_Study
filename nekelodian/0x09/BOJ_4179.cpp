#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
string board[1001];
int dist1[1001][1001];  //Fire
int dist2[1001][1001];  //Jihun
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
int n,m;
queue<pair<int,int>> q1;
queue<pair<int,int>> q2;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> m;
    fill(&dist1[0][0], &dist1[n-1][m], -1);
    fill(&dist2[0][0], &dist2[n-1][m], -1);
    for(int i=0; i<n; i++)
        cin >> board[i];
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            if(board[i][j] == 'F'){
                q1.push({i,j});
                dist1[i][j] = 0;
            }
            if(board[i][j] == 'J'){
                q2.push({i,j});
                dist2[i][j] = 0;
            }
        }
    }
    //Fire distance
    while(!q1.empty()){
        pair<int,int> cur = q1.front(); q1.pop();
        for(int dir=0; dir<4; dir++){
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m)  continue;
            if(dist1[nx][ny] >= 0 || board[nx][ny] == '#')   continue;
            dist1[nx][ny] = dist1[cur.X][cur.Y] + 1;
            q1.push({nx,ny});
        }
    }
    //Jihun run!!
    while(!q2.empty()){
        pair<int,int> cur = q2.front(); q2.pop();
        for(int dir=0; dir<4; dir++){
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m){
                cout << dist2[cur.X][cur.Y]+1;
                return 0;
            }
            if(dist2[nx][ny] >= 0 || board[nx][ny] == '#')   continue;
            if(dist2[cur.X][cur.Y]+1 >= dist1[nx][ny] && dist1[nx][ny] != -1)  continue;
            dist2[nx][ny] = dist2[cur.X][cur.Y] + 1;
            q2.push({nx,ny});
        }
    }
    cout << "IMPOSSIBLE";
    return 0;
}
