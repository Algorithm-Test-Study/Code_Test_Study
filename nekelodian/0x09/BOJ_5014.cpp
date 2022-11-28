#include <bits/stdc++.h>
using namespace std;

int temp[1000000];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int f, s, g, u, d;
    cin >> f >> s >> g >> u >> d;
    
    queue<int> q;
    q.push(s);
    temp[s] = 1;
    
    while(!q.empty()){
        int cur = q.front();
        q.pop();
        if(cur == g){
            cout << temp[cur] - 1;
            return 0;
        }
        
        int next[2] = {cur+u, cur-d};
        for(int i=0; i<2; i++){
            if(1 <= next[i] && next[i] <= f && temp[next[i]] == 0){
                temp[next[i]] = temp[cur]+1;
                q.push(next[i]);
            }
        }
    }
    cout << "use the stairs";
    
    return 0;
}
