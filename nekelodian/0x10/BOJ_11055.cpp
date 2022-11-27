#include <bits/stdc++.h>
using namespace std;

int a[1005], dp[1005];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int n;
    cin >> n;
    for(int i=1; i<=n; i++)  cin >> a[i];
    
    int max = 0;
    for(int i=1; i<=n; i++){
        dp[i] = a[i];
        for(int j=1; j<i; j++){
            if(a[i] > a[j] && dp[i] < dp[j]+a[i])
                dp[i] = dp[j]+a[i];
        }
        if(max < dp[i]) max = dp[i];
    }
    cout << max;
    
    return 0;
}
