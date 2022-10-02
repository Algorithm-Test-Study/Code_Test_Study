#include <bits/stdc++.h>
using namespace std;
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    stack<int> S, idx;
    vector<int> ans;
    int n;
    cin >> n;
    int cnt = 1, x;
    cin >> x;
    S.push(x);
    idx.push(cnt++);
    ans.push_back(0);
    
    for(int i=1; i<n; i++){
        cin >> x;
        if(!S.empty() && x > S.top()){
            while(!S.empty() && x > S.top()){
                S.pop();
                idx.pop();
            }
            if(S.empty())   ans.push_back(0);
            else{
                ans.push_back(idx.top()); 
            }
            S.push(x);
            idx.push(cnt++);
        }else{
            ans.push_back(idx.top());
            S.push(x);
            idx.push(cnt++);
        }
    }
    for(int i=0; i<n; i++)  cout << ans[i] << ' ';
    
    return 0;
}
