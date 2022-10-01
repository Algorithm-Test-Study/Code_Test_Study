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

/*
//스택구현
#include <bits/stdc++.h>
using namespace std;
const int MX = 100000;
int dat[MX];
int pos = 0;

void push(int x){
    dat[pos++] = x;
}
void pop(){
    pos--;
}
int top(){
    return dat[pos-1];
}

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
            push(i);
        }else if(c=="pop"){
            if(pos == 0)
                cout << "-1\n";
            else{
                cout << top() << '\n';
                pop();
            }
        }else if(c=="size"){
            cout << pos << '\n';
        }else if(c=="empty"){
            if(pos == 0)
                cout << "1\n";
            else
                cout << "0\n";
        }else if(c=="top"){
            if(pos == 0)
                cout << "-1\n";
            else
                cout << top() << '\n';
        }
    }
    return 0;
}
*/
