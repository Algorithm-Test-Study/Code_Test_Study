#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;
    vector<string> v(n);
    vector<long long> answer;

    for(int i=0; i<n; i++){
        cin >> v[i];
        reverse(v[i].begin(), v[i].end());
        answer.push_back(stoll(v[i]));
    }

    sort(answer.begin(), answer.end());

    for(int i=0; i<n; i++)
        cout << answer[i] << '\n';

    return 0;
}