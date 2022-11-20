#include <bits/stdc++.h>
using namespace std;

string str;
int flag, ans;
string tmp;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> str;
    for(int i=0; i<=str.size(); i++){
        if(str[i] == '+' || str[i] == '-' || str[i]=='\0'){
            if(flag){
                ans -= stoi(tmp);
            }else{
                ans += stoi(tmp);
            }
            if(str[i] == '-'){
                flag = 1;
            }
            tmp = "";
        }
        else
            tmp += str[i];
    }
    cout << ans;
    
    return 0;
}
