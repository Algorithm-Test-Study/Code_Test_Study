#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, w, l;
    cin >> n >> w >> l;
    vector<int> v(n);
    for(int i=0; i<n; i++) cin >> v[i];

    queue<int> q;
    int ans = 0, sum = 0;
    for(int i=0; i<n; i++){
        while(true){
            if(q.size() == w){
                sum -= q.front();
                q.pop();
            }
            if(sum + v[i] <= l) break;  // 버틸 수 있는 하중일 경우 while문 밖으로 나가 해당 트럭의 무게를 push
            q.push(0);                  // size가 곧 지난 시간이라 가정하기 위해 값을 넣지 못한 경우를 대비해 0을 넣어 줌
            ans++;
        }
        q.push(v[i]);
        sum += v[i];
        ans++;
    }
    cout << ans + w;

    return 0;
}