#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    priority_queue<long long, vector<long long>, greater<long long>> pq;
    int n, m;
    long long num, ans = 0;
    cin >> n >> m;
    vector<int> v(n);
    for(int i=0; i<n; i++){
        cin >> num;
        pq.push(num);
    }

    while(m--){
        long long first = pq.top(); pq.pop();
        long long second = pq.top(); pq.pop();
        long long sum = first + second;
        pq.push(sum);
        pq.push(sum);
    }

    while(!pq.empty()){
        ans += pq.top();
        pq.pop();
    }

    cout << ans;

    return 0;
}