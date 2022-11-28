#include <bits/stdc++.h>
using namespace std;

int ans;
int n, m, g, r;
int brownSoilSize;                  // 배양액을 뿌릴 수 있는 땅의 수
int board[50][50];
int gtime[50][50];                  // 초록색 배양액이 퍼진 시간
int rtime[50][50];                  // 빨간색 배양액이 퍼진 시간
bool flower[50][50];                // 피어있는 꽃

vector<pair<int, int>> brownSoil;   // 배양액을 뿌릴 좌표
vector<pair<int, int>> green;       // 초록색 배양액을 뿌릴 좌표
vector<pair<int,  int>> red;        // 빨간색 배양액을 뿌릴 좌표

int dx[] = {1, 0, -1, 0};
int dy[] = {0, 1, 0, -1};

void bfs(){
    queue<pair<int, int>> gq, rq;

    memset(gtime, -1, sizeof(gtime));
    memset(rtime, -1, sizeof(rtime));
    memset(flower, false, sizeof(flower));

    // 각 배양액을 뿌린 땅을 큐에 넣어준다.
    for(pair<int, int> p : green){
        gq.push(make_pair(p.first, p.second));
        gtime[p.first][p.second] = 0;
    }
    for(pair<int, int> p : red){
        rq.push(make_pair(p.first, p.second));
        rtime[p.first][p.second] = 0;
    }

    int fcnt = 0;
    while(!gq.empty() || !rq.empty()){
        // 초록 배양액이 퍼지는 bfs
        int gqsize = gq.size();
        while(gqsize--){
            int x = gq.front().first;
            int y = gq.front().second;
            gq.pop();
            
            // 이미 꽃이 피었다면 다음 위치 탐색
            if(flower[x][y]) continue;
            for(int dir = 0; dir < 4; dir++){
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(gtime[nx][ny] != -1) continue;
                if(board[nx][ny] == 0) continue;
                if(rtime[nx][ny] != -1) continue;

                gtime[nx][ny] = gtime[x][y] + 1;
                gq.push(make_pair(nx, ny));
            }
        }

        // 빨간 배양액이 퍼지는 bfs
        int rqsize = rq.size();
        while(rqsize--){
            int x = rq.front().first;
            int y = rq.front().second;
            rq.pop();

            for(int dir = 0; dir < 4; dir++){
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(board[nx][ny] == 0) continue;
                if(rtime[nx][ny] != -1) continue;
                // 초록색 배양액이 있는지 확인
                if(gtime[nx][ny] == -1){
                    rtime[nx][ny] = rtime[x][y] + 1;
                    rq.push(make_pair(nx, ny));
                }
                // 초록색 배양액과 빨간색 배양액이 동일한 시간에 도달한 땅에서 꽃이 핀다.
                else if(gtime[nx][ny] == rtime[x][y] + 1){
                    flower[nx][ny] = true;
                    rtime[nx][ny] = rtime[x][y] + 1;
                    fcnt++;
                }
            }
        }
    }
    ans = max(ans, fcnt);
}

void select(int idx, int gcnt, int rcnt){
    // 주어진 모든 배양액을 남김없이 사용해야 함.
    if(gcnt + rcnt > brownSoilSize - idx) return;
    if(gcnt == 0 && rcnt == 0){
        bfs();
        return;
    }
    if(idx == brownSoilSize) return;
    
    int x = brownSoil[idx].first;
    int y = brownSoil[idx].second;

    // idx에 배양액 안뿌린 경우
    select(idx + 1, gcnt, rcnt);
    // idx에 초록 배양액을 뿌린 경우
    if(gcnt > 0){
        green.push_back(make_pair(x, y));
        select(idx+1, gcnt - 1, rcnt);
        green.pop_back();
    }
    // idx에 빨간 배양액을 뿌린 경우
    if(rcnt > 0){
        red.push_back(make_pair(x, y));
        select(idx+1, gcnt, rcnt-1);
        red.pop_back();
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    ans = 0;
    cin >> n >> m >> g >> r;
    for(int i=0; i<n; i++)
        for(int j=0; j<m; j++){
            cin >> board[i][j];
            if(board[i][j] == 2) brownSoil.push_back(make_pair(i, j));
        }
    brownSoilSize = brownSoil.size();
    select(0, g, r);

    cout << ans;

    return 0;
}