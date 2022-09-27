#include <bits/stdc++.h>
using namespace std;

int main()
{
    cin.tie(0); ios::sync_with_stdio(0);

    int x, n;
    string str;
    deque<int> dq;

    cin >> n;
    while(n--){
        cin >> str;
        if(str == "push_front"){
            cin >> x;
            dq.push_front(x);
        }
        else if(str == "push_back"){
            cin >> x;
            dq.push_back(x);
        }
        else if(str == "pop_front"){
            if(dq.empty()) cout << "-1\n";
            else{
                cout << dq.front() << "\n";
                dq.pop_front();
            }
        }
        else if(str == "pop_back"){
            if(dq.empty()) cout << "-1\n";
            else{
                cout << dq.back() << "\n";
                dq.pop_back();
            }
        }
        else if(str == "size"){
            cout << dq.size() << "\n";
        }
        else if(str == "empty"){
            if(dq.empty()) cout << "1\n";
            else cout << "0\n";
        }
        else if(str == "front"){
            if(dq.empty()) cout << "-1\n";
            else cout << dq.front() << "\n";
        }
        else if(str == "back"){
            if(dq.empty()) cout << "-1\n";
            else cout << dq.back() << "\n";
        }
    }

    return 0;
}