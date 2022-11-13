#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    
    int n;
    vector<long long> v;
    cin >> n;
    for(int i=0; i<n; i++){
        string str;
        cin >> str;
        reverse(str.begin(), str.end());
        v.push_back(stoll(str));
    }
    sort(v.begin(), v.end());
    for(auto i : v)
        cout << i << '\n';
    
    return 0;
}
