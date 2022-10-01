#include <bits/stdc++.h>
using namespace std;
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    stack<int> S;
    int k;
    cin >> k;
    while(k--){
        int i;
        cin >> i;
        if(i){
            S.push(i);
        }else{
            S.pop();
        }
    }
    int sum = 0, a = S.size();
    while(a--){
        sum += S.top();
        S.pop();
    }
    cout << sum;
    return 0;
}
