#include <bits/stdc++.h>
using namespace std;


bool cmp(const pair<int,int> &a,const pair<int,int> &b){
    return a.first > b.first;
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int n, c;
    vector<pair<int,int>> v;
    cin >> n >> c;
    for(int i=0; i<n; i++){
        int msg;
        cin >> msg;
        int flag = 0;
        for(auto &a : v){
            if(msg == a.second){
                flag = 1;
                a.first++;
                break;
            }
        }
        if(flag == 0)   v.push_back({1, msg});
    }
    stable_sort(v.begin(), v.end(), cmp);
    for(auto b : v)
        while(b.first--)
            cout << b.second << ' ';
    
    return 0;
}
