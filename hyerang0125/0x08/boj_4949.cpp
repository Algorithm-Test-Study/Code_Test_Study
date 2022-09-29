#include <bits/stdc++.h>
using namespace std;

int main()
{

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    string str;
    bool check;

    while(true){
        stack<char> s;
        getline(cin, str);
        if(str.size() == 1 && str[0] == '.') return 0;

        check = true;
        for(int i=0; i<str.size(); i++){
            if (str[i] == '(' || str[i] == '[') s.push(str[i]);
            else if(str[i] == ')' ){
                if(!s.empty() && s.top() == ')') s.pop();
                else{
                    check = false; break;
                }
            }
            else if(str[i] == ']'){
                if (!s.empty() && s.top() == '[') s.pop();
                else {
                    check = false; break;
                }
            }
        }
        if(s.empty() && check) cout << "yes\n";
        else cout << "no\n";
    }

    return 0;
}