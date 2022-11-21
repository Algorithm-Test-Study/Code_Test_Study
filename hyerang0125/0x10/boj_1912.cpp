#include <bits/stdc++.h>
using namespace std;

int dp[100001] = {0, };

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;
    vector<int> num(n);

    for(int i=0; i<n; i++){
        cin >> num[i];
        dp[i] = num[i];
    }

    int maxSum = dp[0];
    for(int i=1; i<n; i++){
        dp[i] = max(dp[i], dp[i-1]+num[i]);
        if(dp[i] > maxSum) maxSum = dp[i];
    }

    cout << maxSum;

    return 0;
}