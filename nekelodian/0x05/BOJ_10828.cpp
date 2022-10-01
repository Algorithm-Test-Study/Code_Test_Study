#include <bits/stdc++.h>
using namespace std;
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    stack<int> S;
    int n;
    cin >> n;
    while(n--){
        string c;
        cin >> c;
        if(c=="push"){
            int i;
            cin >> i;
            S.push(i);
        }else if(c=="pop"){
            if(S.empty())
                cout << "-1\n";
            else{
                cout << S.top() << '\n';
                S.pop();
            }
        }else if(c=="size"){
            cout << S.size() << '\n';
        }else if(c=="empty"){
            if(S.empty())
                cout << "1\n";
            else
                cout << "0\n";
        }else if(c=="top"){
            if(S.empty())
                cout << "-1\n";
            else
                cout << S.top() << '\n';
        }
    }
    return 0;
}
