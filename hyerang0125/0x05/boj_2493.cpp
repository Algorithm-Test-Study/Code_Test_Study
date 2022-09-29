#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, height;
    stack<pair<int, int>> s;

    cin >> n;
    for(int i=1; i<=n; i++){
        cin >> height;
        while(!s.empty()){
            if(s.top().first > height){
                cout << s.top().second << " ";
                break;
            }
            s.pop();
        }
        if(s.empty())
            cout << "0 ";
        s.push(make_pair(height, i));
    }

    return 0;
}