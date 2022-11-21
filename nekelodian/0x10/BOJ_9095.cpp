#include <bits/stdc++.h>
using namespace std;

int d[12];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n, t;
    cin >> t;
    for(int i=0; i<t; i++){
        cin >> n;
        d[1] = 1, d[2] = 2, d[3] = 4;
        for(int i=4; i<=n; i++){
            d[i] = d[i-1]+d[i-2]+d[i-3];
        }
        cout << d[n] << '\n';
    }
    return 0;
}
