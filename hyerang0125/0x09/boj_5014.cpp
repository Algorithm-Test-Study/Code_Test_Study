#include <bits/stdc++.h>
using namespace std;
int F, S, G, U, D;
int path[1000001];
int visited[1000001];
int dx[2];
queue<int> q;

void bfs(int v){
    visited[v] = 1;
    q.push(v);

    while(!q.empty()){
        v = q.front();
        q.pop();
        for(int i=0; i<2; i++){
            int nv = v + dx[i];
            if(nv <= 0 || F < nv || visited[nv] == 1) continue;
            visited[nv] = 1;
            q.push(nv);
            path[nv] = path[v] + 1;
        }
    }
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    
    cin >> F >> S >> G >> U >> D;
    dx[0] = U, dx[1] = -D; 
    visited[S] = 1, path[S] = 0;
    bfs(S);
    if(visited[G]) cout << path[G];
    else cout << "use the stairs";

    return 0;
}