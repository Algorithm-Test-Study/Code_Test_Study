#include <bits/stdc++.h>
using namespace std;

int d[1002][1002];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    string a, b;
    cin >> a >> b;
    
    for(int i=1; i <= a.size(); i++){
        for(int j=1; j <= b.size(); j++){
            if(a[i-1] == b[j-1])    d[i][j] = d[i-1][j-1] + 1;
            else
                d[i][j] = max(d[i-1][j], d[i][j-1]);
        }
    }
    cout << d[a.size()][b.size()];
    return 0;
}
