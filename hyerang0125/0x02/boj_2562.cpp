#include <bits/stdc++.h>
using namespace std;

int main()
{
    int max, idx, n;

    max = idx = 0;
    for(int i=1; i<=9; i++){
        cin >> n;
        if(n > max) max = n, idx = i;
    }
    cout << max << endl;
    cout << idx << endl;

    return 0;
}