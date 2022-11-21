#include <bits/stdc++.h>
using namespace std;

int d[100005], a[100005];
int n, ret;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    for(int i=1; i<=n; i++){
        cin >> a[i];
    }
    d[1] = a[1];
    for(int i=2; i<=n; i++){
        d[i] = max(d[i-1]+a[i], a[i]);
    }
    ret = d[1];
    for(int i=2; i<=n; i++){
        ret = max(ret, d[i]);
    }
    cout << ret;
    
    return 0;
}
