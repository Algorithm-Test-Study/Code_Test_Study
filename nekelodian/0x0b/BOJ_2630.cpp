#include <bits/stdc++.h>
using namespace std;

int cnt[2];
int paper[2190][2190];

int check(int x, int y, int n){
    for(int i=x; i<x+n; i++)
        for(int j=y; j<y+n; j++)
            if(paper[x][y] != paper[i][j])
                return 0;
    return 1;
}

void func(int x, int y, int n){
    if(check(x,y,n) == 1){
        cnt[paper[x][y]]++;
        return;
    }
    for(int i=0; i<2; i++)
        for(int j=0; j<2; j++){
            int nx = x+i*n/2;
            int ny = y+j*n/2;
            func(nx, ny, n/2);
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
    for(int i=0; i<2; i++)  cout << cnt[i] << "\n";

    return 0;
}
