#include <bits/stdc++.h>
using namespace std;

int n;
pair<int, int> s[100005];   //end time, start time

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> n;
    for(int i=0; i<n; i++){
        cin >> s[i].second >> s[i].first;
    }
    sort(s, s+n);   //end, start 순으로 정렬
    
    int ans = 0; //회의 개수 
    int t = 0;  //현재시간
    for(int i=0; i<n; i++){
        if(t > s[i].second) continue;
        ans++;
        t = s[i].first; //현재 시간을 끝나는 시간으로 변경
    }
    cout << ans;
    
    return 0;
}
