#include <bits/stdc++.h>
using namespace std;

int cnt[3];
int paper[2190][2190];

int check(int x, int y, int m){
    for(int i=x; i<x+m; i++)
        for(int j=y; j<y+m; j++)
            if(paper[x][y] != paper[i][j])
                return 0;
    return 1;
}

void func(int x, int y, int z){
    if(check(x,y,z) == 1){
        cnt[paper[x][y]+1] += 1;
        return;
    }
    int n = z/3;
    for(int i=0; i<3; i++){
        for(int j=0; j<3; j++){
            int nx = x+n*i;
            int ny = y+n*j;
            func(nx, ny, n);
        }
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int n;
    cin >> n;
    for(int i=0; i<n; i++)
        for(int j=0; j<n; j++)
            cin >> paper[i][j];
    
    func(0, 0, n);
    for(int i=0; i<3; i++)  cout << cnt[i] << "\n";

    return 0;
}
