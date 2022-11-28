#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int tc, n, m;
    cin >> tc;

    while(tc--){
        int cnt = 0;

        cin >> n >> m;
        vector<int> A(n);
        vector<int> B(m);
        for(int i=0; i<n; i++) cin >> A[i];
        for(int i=0; i<m; i++) cin >> B[i];

        sort(A.begin(), A.end());
        sort(B.begin(), B.end());

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(A[i] > B[j]) cnt++;
                else break;
            }
        }
        cout << cnt << '\n';
    }

    return 0;
}