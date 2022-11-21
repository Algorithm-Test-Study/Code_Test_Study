#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int t;
    cin >> t;
    while(t--){
        int n = 0;
        cin >> n;
        int a[n];
        for(int i=0; i<n; i++)  cin >> a[i];
        
        int max = -1;
        long long ans = 0;
        for(int i=n-1; i>=0; i--){
            max = a[i] > max ? a[i] : max;
            ans += max - a[i];
        }
        cout << ans << "\n";
    }
    
    return 0;
}
