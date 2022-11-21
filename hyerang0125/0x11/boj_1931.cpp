#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;
    vector<pair<int, int>> timeList(n);
    for(int i=0; i<n; i++)
        cin >> timeList[i].second >> timeList[i].first;     // make_pair(끝나는 시간, 시작하는 시간) 모양이 되도록 입력받음

    // 가장 빨리 끝나는 회의들을 기준으로 회의를 세기 위함 
    sort(timeList.begin(), timeList.end());

    int temp = timeList[0].first;
    int cnt = 1;

    for(int i=1; i<n; i++){
        // 만약 시작하는 시간보다 끝나는 시간이 더 작다면 회의를 할 수 있다는 것 
        if(timeList[i].second >= temp){
            cnt++; temp = timeList[i].first;
        }
    }

    cout << cnt;

    return 0;
}