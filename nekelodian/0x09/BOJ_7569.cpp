#include <bits/stdc++.h>
using namespace std;
// #define X first
// #define Y second
int board[100][100][100];
int dist[100][100][100];
int dz[6] = {1,0,0,-1,0,0};
int dx[6] = {0,1,0,0,-1,0};
int dy[6] = {0,0,1,0,0,-1};
int m,n,h;
queue<tuple<int,int,int>> q;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> m >> n >> h;
    fill(&dist[0][0][0],&dist[h][n][m],-1);
    for(int i=0; i<h; i++){
        for(int j=0; j<n; j++){
            for(int k=0; k<m; k++){
                cin >> board[i][j][k];
                if(board[i][j][k] == 1){
                    q.push({i,j,k});
                    dist[i][j][k] = 0;
                }
            }
        }
    }
    
    int max = 0;
    while(!q.empty()){
        tuple<int,int,int> cur = q.front(); q.pop();
        for(int dir=0; dir<6; dir++){
            int nz = get<0>(cur) + dz[dir];
            int nx = get<1>(cur) + dx[dir];
            int ny = get<2>(cur) + dy[dir];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m || nz < 0 || nz >= h)  continue;
            if(dist[nz][nx][ny] >= 0 || board[nz][nx][ny] != 0)   continue;
            dist[nz][nx][ny] = dist[get<0>(cur)][get<1>(cur)][get<2>(cur)] + 1;
            if(dist[nz][nx][ny] > max)  //find max
                max = dist[nz][nx][ny];
            q.push({nz,nx,ny});
        }
    }
    for(int i=0; i<h; i++){
        for(int j=0; j<n; j++){
            for(int k=0; k<m; k++){
                if(board[i][j][k] == 0 && dist[i][j][k] == -1){
                    cout << "-1";
                    return 0;
                }
            }
        }
    }
    cout << max;
    return 0;
}
