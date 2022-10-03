#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n, l;
    deque<pair<int, int>> dq;
    
    cin >> n >> l;
    vector<int> v(n);
    for(int i=0; i<n; i++){
        cin >> v[i];
    }

    for(int i=0; i<n; i++){
        if(!dq.empty() && dq.front().second <= i-l) dq.pop_front();
        while(!dq.empty() && dq.back().first > v[i]) dq.pop_back();
        dq.push_back(make_pair(v[i], i));
        cout << dq.front().first << " ";
    }

    return 0;
}