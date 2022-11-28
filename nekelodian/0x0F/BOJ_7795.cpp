#include <bits/stdc++.h>
using namespace std;

vector<int> a, b;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int t;
    cin >> t;
    for(int T=0; T<t; T++){
        int n, m;
        cin >> n >> m;
        a = vector<int>(n);
        b = vector<int>(m);
        for(int i=0; i<n; i++)  cin >> a[i];
        for(int i=0; i<m; i++)  cin >> b[i];
        sort(a.begin(), a.end());
        sort(b.begin(), b.end());
        
        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(a[i] > b[j]) ans++;
                else    break;
            }
        }
        cout << ans << '\n';
    }
    return 0;
}
