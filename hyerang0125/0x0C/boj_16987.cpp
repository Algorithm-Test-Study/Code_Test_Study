#include <bits/stdc++.h>
using namespace std;

int cnt, n;
int egg[8][2];

void dfs(int depth){
    bool flag = false;
    if (depth == n){
        int temp = 0;
        for(int i=0; i<n; i++)
            if(egg[i][0] <= 0) temp++;
        cnt = cnt > temp ? cnt : temp;
        return;
    }
    if (egg[depth][0] <= 0) dfs(depth + 1);
    else{
        for(int i=0; i<n; i++){
            if(depth == i || egg[i][0] <= 0) continue;
            egg[i][0] -= egg[depth][1]; egg[depth][0] -= egg[i][1];
            flag = true;
            dfs(depth + 1);
            egg[i][0] += egg[depth][1]; egg[depth][0] += egg[i][1];
        }
        if(!flag) dfs(n);
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    for(int i=0; i<n; i++)
        cin >> egg[i][0] >> egg[i][1];
    
    dfs(0);
    cout << cnt;

    return 0;
}