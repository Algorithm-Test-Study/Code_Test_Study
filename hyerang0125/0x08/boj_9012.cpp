#include <bits/stdc++.h>
using namespace std;

int main()
{

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    string str;
    bool check;

    cin >> n;
    while (n--)
    {
        stack<char> s;
        cin >> str;

        check = true;
        for (int i = 0; i < str.size(); i++){
            if (str[i] == '(')
                s.push(str[i]);
            else{
                if (!s.empty() && s.top() == '(')
                    s.pop();
                else{
                    check = false;
                    break;
                }
            }
        }
        if (s.empty() && check)
            cout << "YES\n";
        else
            cout << "NO\n";
    }

    return 0;
}