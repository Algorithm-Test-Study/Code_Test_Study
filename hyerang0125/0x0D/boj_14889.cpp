#include <bits/stdc++.h>
using namespace std;

int n, result = 10000000;
int nn[21][21];
bool check[21];

void dfs(int cnt, int pos){
    if(cnt == n / 2){
        int start = 0, link = 0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i == j) continue;
                if(check[i] && check[j]) start += nn[i][j];
                if(!check[i] && !check[j]) link += nn[i][j];
            }
        }
        result = min(result, abs(start - link));
        return ;
    }

    for(int i=pos; i<n; i++){
        check[i] = true;
        dfs(cnt+1, i+1);
        check[i] = false;
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    for(int i=1; i<=n; i++){
        for(int j=1; j<=n; j++)
            cin >> nn[i][j];
    }
    dfs(0, 1);
    cout << result;

    return 0;
}