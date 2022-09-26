#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n, set, sum;
    int start, end;

    cin >> n;
    vector<int> list(n);
    for(int i=0; i<n; i++){
        cin >> list[i];
    }
    cin >> sum;

    sort(list.begin(), list.end());
    set = start = 0; end = n-1;
    while(start < end){
        if(list[start] + list[end] == sum) set++, end--;
        if(list[start] + list[end] < sum) start++;
        else end--;
    }
    cout << set;

    return 0;
}