#include <bits/stdc++.h>
using namespace std;

int main()
{
    int x, n;
    string str;
    stack<int> s;

    cin >> n;
    for(int i=0; i<n; i++){
        cin >> str;
        if(str == "push"){
            cin >> x;
            s.push(x);
        }
        else if(str == "pop"){
            if(s.empty()) cout << "-1" << endl;
            else{
                cout << s.top() << endl;
                s.pop();
            }
        }
        else if(str == "size"){
            cout << s.size() << endl;
        }
        else if(str == "empty"){
            if(s.empty()) cout << "1" << endl;
            else cout << "0" << endl;
        }
        else if(str == "top"){
            if(s.empty()) cout << "-1" << endl;
            else cout << s.top() << endl;
        }
    }

    return 0;
}