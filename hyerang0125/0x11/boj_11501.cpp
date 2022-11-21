#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int t, n, temp;

    cin >> t;
    while(t--){
        cin >> n;
        vector<int> v;
        for (int i = 0; i < n; i++)
        {
            cin >> temp;
            v.push_back(temp);
        }

        long long ans = 0;
        int max_val = -1;

        for (int i = n - 1; i >= 0; i--)
        {
            max_val = max(max_val, v[i]);
            ans += max_val - v[i];
        }

        cout << ans << endl;
    }

    return 0;
}