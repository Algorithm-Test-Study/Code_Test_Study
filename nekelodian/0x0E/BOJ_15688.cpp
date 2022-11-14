#include <bits/stdc++.h>
using namespace std;

int n;
int cnt[2000002];

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    int a;
    for(int i=0; i<n; i++){
        cin >> a;
        cnt[a+1000000]++;
    }
    
    for(int i=0; i<=2000000; i++){
        while(cnt[i]--)
            cout << i-1000000 << '\n';
    }
    return 0;
}
