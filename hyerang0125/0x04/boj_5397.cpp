#include <bits/stdc++.h>
using namespace std;

string KL(string str);

int main()
{
    int n;
    string str;

    cin >> n;
    for(int i=0; i<n; i++){
        cin >> str;
        cout << KL(str) << endl;
    }

    return 0;
}

string KL(string str)
{
    string result = "";
    stack<char> pwd, temp;

    for(int i=0; i<str.size(); i++){
        if(str[i] == '<'){
            if(pwd.empty()) continue;
            else{
                temp.push(pwd.top());
                pwd.pop();          
            }

        }
        else if(str[i] == '>'){
            if(temp.empty()) continue;
            else {
                pwd.push(temp.top());
                temp.pop();
            }
        }
        else if(str[i] == '-'){
            if(pwd.empty()) continue;
            else pwd.pop();
        }
        else pwd.push(str[i]);
    }

    while(!temp.empty()){
        pwd.push(temp.top());
        temp.pop();
    }

    while (!pwd.empty()) {
        result += pwd.top();
        pwd.pop();
    }
    reverse(result.begin(), result.end());

    return result;
}