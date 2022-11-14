#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    int x, y;
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;

    cin >> n;
    for(int i=0; i<n; i++){
        cin >> x >> y;
        pq.push(make_pair(x, y));
    }

    for(int i=0; i<n; i++){
        cout << pq.top().X << " " << pq.top().Y << '\n';
        pq.pop();
    }

    return 0;
}