#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int ans, temp;
    string str;
    bool flag = false;
    ans = temp = 0;

    cin >> str;
    for(int i=0; i<=str.length(); i++){
        if(str[i] == '-' || str[i] == '+' || i == str.length()){
            if(!flag){
                ans += temp; temp = 0;
            }
            else{
                ans -= temp; temp = 0;
            }
            if(str[i] == '-') flag = true;
        }
        else{
            temp = temp * 10 + (str[i] - '0');
        }
    }

    cout << ans;

    return 0;
}