#include <bits/stdc++.h>
using namespace std;

int n;
int w[100005];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> n;
    for(int i=0; i<n; i++)  cin >> w[i];
    sort(w, w+n);
    int ans = 0;
    for(int k=1; k<=n; k++) ans = max(ans, w[n-k]*k);
    cout << ans;
    
    return 0;
}
