#include <bits/stdc++.h>
using namespace std;

string str;
string tmp[1000];

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> str;
    int len = str.length();
    for(int i=0; i<len; i++){
        tmp[i] = str.substr(i);
    }
    sort(tmp, tmp+len);
    for(int i=0; i<len; i++)
        cout << tmp[i] << '\n';
    
    return 0;
}
