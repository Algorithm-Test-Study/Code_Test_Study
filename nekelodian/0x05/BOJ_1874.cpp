#include <bits/stdc++.h>
using namespace std;
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    stack<int> tmp;
    int n, x;
    cin >> n;
    int seq[n];
    string c;
    
    for(int i=0; i<n; i++){
        cin >> seq[i];
    }
    
    int cnt = 0;
    for(int i=1; i<=n; i++){
        tmp.push(i);
        c += "+\n";
        while(!tmp.empty() && tmp.top() == seq[cnt]){
            tmp.pop();
            c += "-\n";
            cnt++;
        }
    }
    if(!tmp.empty()){
        cout << "NO";
    }else{
        cout << c;
    }
    return 0;
}
