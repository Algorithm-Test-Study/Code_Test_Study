#include <bits/stdc++.h>
using namespace std;

map<int, int> order;

bool cmp(pair<int, int>&a, pair<int, int>& b){
    if(a.second == b.second)
        return order[a.first] < order[b.first];
    return a.second > b.second;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, c;
    cin >> n >> c;

    map<int, int> m;
    int num;

    for (int i = 0; i < n; i++)
    {
        cin >> num;
        m[num]++;
        if(order[num] == 0) order[num] = i+1;
    }

    vector<pair<int, int>> v(m.begin(), m.end());

    sort(v.begin(), v.end(), cmp);

    for (auto x : v)
        for(int i=0; i<x.second; i++)
            cout << x.first << " ";

    return 0;
}