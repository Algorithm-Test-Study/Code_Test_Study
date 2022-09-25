#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n, target, result;

    cin >> n;
    vector<int> list(n);
    for(int i=0; i<n; i++)
        cin >> list[i];
    cin >> target;

    result = 0;
    for(int i=0; i<n; i++){
        if(list[i] == target) result++;
    }

    cout << result;

    return 0;
}