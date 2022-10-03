#include <bits/stdc++.h>
using namespace std;

int main()
{

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int result, temp;
    string str;
    stack<char> s;

    cin >> str;
    result = 0, temp = 1;
    for(int i=0; i<str.length(); i++){
        if(str[i] == '('){
            s.push(str[i]);
            temp *= 2;
        }
        else if(str[i] == ')'){
            if(s.empty() || s.top() != '('){
                result = 0;
                break;
            }
            if(str[i-1] == '(')
                result += temp;
            s.pop();
            temp /= 2;
        }
        else if(str[i] == '['){
            s.push(str[i]);
            temp *= 3;
        }
        else if(str[i] == ']'){
            if(s.empty() || s.top() != '['){
                result = 0;
                break;
            }
            if(str[i-1] == '[')
                result += temp;
            s.pop();
            temp /= 3;
        }
    }

    if(s.empty()) cout << result;
    else cout << 0;

    return 0;
}