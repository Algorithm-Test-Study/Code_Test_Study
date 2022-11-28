#include <bits/stdc++.h>
using namespace std;

long long a[1005];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n, m;
    cin >> n >> m;
    for(int i=0; i<n; i++)  cin >> a[i];
    while(m--){
        sort(a, a+n);
        long long sum = a[0] + a[1];
        a[0] = sum, a[1] = sum;
    }
    long long ans = 0;
    for(int i=0; i<n; i++)  ans += a[i];
    cout << ans;
    
    return 0;
}
