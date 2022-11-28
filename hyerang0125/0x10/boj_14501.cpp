#include <bits/stdc++.h>
using namespace std;
#define time first
#define pay second

int dp[16];
vector<pair<int, int>> v(16);

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, answer = 0;
    cin >> n;
    for(int i=1; i<=n; i++){
        cin >> v[i].time >> v[i].pay;
        for(int j=0; j<i; j++){
            if(v[j].time + j <= i && i + v[i].time <= n+1)
                dp[i] = max(dp[i], dp[j] + v[i].pay);
        }
    }
    for(int i=0; i<=n; i++)
        answer = max(answer, dp[i]);
    cout << answer;

    return 0;
}