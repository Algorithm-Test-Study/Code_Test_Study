#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n, m, target, cnt, idx;
    cin >> n >> m;
    deque<int> dq;
    for(int i=1; i<=n; i++) dq.push_back(i);

    cnt = 0;
    for(int i=0; i<m; i++){
        cin >> target;
        for(int j=0; j<dq.size(); j++){
            if(dq[j] == target){
                idx = j; break;
            }
        }

        if(dq.size() - idx > idx){
            while(target != dq.front()){
                dq.push_back(dq.front());
                dq.pop_front();
                cnt++;
            }
        }
        else{
            while (target != dq.front()){
                dq.push_front(dq.back());
                dq.pop_back();
                cnt++;
            }
        }
        dq.pop_front();
    }

    cout << cnt;

    return 0;
}