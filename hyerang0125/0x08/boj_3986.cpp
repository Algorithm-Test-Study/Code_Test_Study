#include <bits/stdc++.h>
using namespace std;

int main()
{

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, sum = 0;
    string str;
    bool check;

    cin >> n;
    for(int i=0; i<n; i++){
        stack<char> s;
        cin >> str;

        for(int j=0; j<str.length(); j++){
            if(s.empty()) s.push(str[j]);
            else if(str[j] == 'A'){
                if(s.top() == 'A') s.pop();
                else{
                    s.push(str[j]);
                }
            }
            else if(str[j] == 'B'){
                if(s.top() == 'B') s.pop();
                else{
                    s.push(str[j]);
                }
            }
        }
        if(s.empty()) sum++;
    }

    cout << sum;

    return 0;
}