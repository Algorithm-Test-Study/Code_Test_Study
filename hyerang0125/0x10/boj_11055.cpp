#include <bits/stdc++.h>
using namespace std;

int n, maxSum;
int arr[1001];
int dp[1001];

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    for(int i=1; i<=n; i++){
        cin >> arr[i];
        for(int j=0; j<i; j++)
            if(arr[j] < arr[i] && dp[i] < dp[j] + arr[i])
                dp[i] = dp[j] + arr[i];
        maxSum = max(maxSum, dp[i]);
    }
    cout << maxSum;

    return 0;
}