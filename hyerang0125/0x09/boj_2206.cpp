#include <bits/stdc++.h>
using namespace std;
#define X get<0>
#define Y get<1>
#define Wall get<2>
#define Cnt get<3>

int N, M;
int board[1001][1001];
int visited[1001][1001][2];
queue<tuple<int, int, int ,int>> q;     // x, y 좌표, 벽 부순 여부, 거리
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

int bfs(){
    visited[0][0][0] = visited[0][0][1] = true;
    q.push(make_tuple(0,0,0,1));    // x와 y, 벽 부순 횟수 0인 곳에서 시작
    while(!q.empty()){
        int x = X(q.front());
        int y = Y(q.front());
        int wall = Wall(q.front());
        int cnt = Cnt(q.front());
        q.pop();

        // 목적지 도착
        if(x == N-1 && y == M-1) return cnt;

        for(int dir=0; dir<4; dir++){
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if(visited[nx][ny][wall]) continue;

            // 벽을 부수지 않고 벽이 없는 곳
            if(wall == 0 && board[nx][ny] == 0){
                visited[nx][ny][wall] = true;
                q.push(make_tuple(nx, ny, 0, cnt+1));
            }
            // 벽을 부수지 않고 벽이 있는 곳
            else if(wall == 0 && board[nx][ny] == 1){
                visited[nx][ny][wall] = true;
                q.push(make_tuple(nx, ny, 1, cnt+1));
            }
            // 벽을 부수고 벽이 없는 곳
            else if(wall == 1 && board[nx][ny] == 0){
                visited[nx][ny][wall] == true;
                q.push(make_tuple(nx, ny, 1, cnt+1));
            }
        }
    }
    return -1;
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    for(int i=0; i<N; i++){
        string temp;
        cin >> temp;
        for(int j=0; j<temp.length(); j++){
            board[i][j] = temp[j] - '0';
        }
    }
    cout << bfs();

    return 0;
}