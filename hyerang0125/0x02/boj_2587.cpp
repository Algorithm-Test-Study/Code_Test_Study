#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n, sum;
    vector<int> nlist;

    sum = 0;
    for(int i=0; i<5; i++){
        cin >> n;
        sum += n, nlist.push_back(n);
    }
    sort(nlist.begin(), nlist.end());
    cout << sum / 5 << endl;
    cout << nlist[2] << endl;

    return 0;
}