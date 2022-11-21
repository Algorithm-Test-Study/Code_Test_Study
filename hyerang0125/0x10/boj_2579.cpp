#include <bits/stdc++.h>
using namespace std;

int d[301];

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;
    vector<int> v(n);
    for(int i=0; i<n; i++)
        cin >> v[i];
    
    d[1] = v[0];
    d[2] = v[0] + v[1];
    d[3] = max(d[1] + v[2], v[1] + v[2]);

    for(int i=4; i<=n; i++)
        d[i] = max(d[i-2] + v[i-1], d[i-3] + v[i-2] + v[i-1]);  // d[i-2] + v[i-1] : 두 계단 오르기 vs. d[i-3] + v[i-2] + v[i-1] : 1계단 연속 오르기

    cout << d[n];

    return 0;
}