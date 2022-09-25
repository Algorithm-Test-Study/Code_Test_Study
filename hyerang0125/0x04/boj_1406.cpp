#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n;
    char op, c;
    string str;
    stack<char> left, right;

    cin >> str;
    for(int i=0; i<str.length(); i++)
        left.push(str[i]);

    cin >> n;
    for (int i = 0; i < n; i++){
        cin >> op;
        switch (op)
        {
        case 'L':
            if(left.empty()) continue;
            else{
                right.push(left.top());
                left.pop();
            }
            break;

        case 'D':
            if(right.empty()) continue;
            else{
                left.push(right.top());
                right.pop();
            }
            break;

        case 'B':
            if(left.empty()) continue;
            else left.pop();
            break;

        case 'P':
            cin >>c;
            left.push(c);
            break;
        }
    }

    while(!left.empty()){
        right.push(left.top());
        left.pop();
    }

    while(!right.empty()){
        cout << right.top();
        right.pop();
    }

    return 0;
}