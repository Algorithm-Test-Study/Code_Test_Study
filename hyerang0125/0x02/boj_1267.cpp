#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n, temp, Y, M;
    vector<int> list;

    cin >> n;
    for(int i=0; i<n; i++){
        cin >> temp;
        list.push_back(temp);
    }
    Y = M = 0;
    for(int i =0; i<n; i++){
        Y += (list[i] / 30 + 1) * 10;
        M += (list[i] / 60 + 1) *15;
    }

    if(Y < M) cout << "Y " << Y;
    else if(Y > M) cout << "M " << M;
    else cout << "Y M " << Y;

    return 0;
}