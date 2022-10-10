#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
int board[1004][1004];
int vis[304][304];
int melt[304][304];
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
int n, m;
void bfs(int i, int j){
    queue<pair<int,int>> q;
    vis[i][j] = 1;
    q.push({i,j});
    while(!q.empty()){
        pair<int,int> cur = q.front(); q.pop();
        for(int dir=0; dir<4; dir++){
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];
            if(nx < 0 || ny < 0 || nx >= n || ny >= m)  continue;
            if(board[nx][ny] == 0 || vis[nx][ny] == 1)   continue;
            vis[nx][ny] = 1;
            q.push({nx,ny});
        }
    }
}


int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> n >> m;
    for(int i=0; i<n; i++)
        for(int j=0; j<m; j++)
            cin >> board[i][j];

    int ice = 0, year = 0;
    
    while(true){
        //빙산 개수 확인 
        ice = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == 0 || vis[i][j] == 1)    continue;
                bfs(i,j);
                ice++;
            }
        }
        if(ice == 0){   //bfs 안돌면 빙산 없음
            cout << 0;
            return 0;
        }
        if(ice >= 2){
            cout << year;
            return 0;
        }
        year++;
        //melting
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!board[i][j])    continue;
                int cnt = 0;
                for(int dir=0; dir<4; dir++){
                    int nx = i + dx[dir];
                    int ny = j + dy[dir];
                    if(nx < 0 || ny < 0 || nx >= n || ny >= m)  continue;
                    if(!board[nx][ny])  cnt++;
                }
                if(cnt) melt[i][j] = cnt; 
            }
        }
        //board - melt
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!melt[i][j]) continue;
                board[i][j] -= melt[i][j];
                if(board[i][j] < 0) board[i][j] = 0;
            }
        }
        //init
        fill(&melt[0][0],&melt[n-1][m],0);
        fill(&vis[0][0],&vis[n-1][m],0);
    }
    return 0;
}
