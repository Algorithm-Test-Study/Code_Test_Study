#include <bits/stdc++.h>
using namespace std;

int d[1000001] = {0, 0, 1, 1};

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    for(int i=4; i<=n; i++){
        d[i] = d[i-1] + 1;
        if(i % 2 == 0 && d[i] > d[i/2] + 1) d[i] = d[i/2] + 1;
        if(i % 3 == 0 && d[i] > d[i/3] + 1) d[i] = d[i/3] + 1; 
    }

    cout << d[n];

    return 0;
}