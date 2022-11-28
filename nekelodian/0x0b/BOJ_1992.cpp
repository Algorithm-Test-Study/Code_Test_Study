#include <bits/stdc++.h>
using namespace std;

int arr[70][70], n;

void func(int n, int y, int x){
    if(n==1){
        cout << arr[y][x];
        return;
    }
    bool zero = true;
    bool one = true;
    for(int i=y; i<y+n; i++){
        for(int j=x; j<x+n; j++){
            if(arr[i][j])   zero = false;
            else    one = false;
        }
    }
    if(zero)    cout << 0;
    else if(one)    cout << 1;
    else{
        cout << "(";
        func(n/2, y, x);
        func(n/2, y, x+n/2);
        func(n/2, y+n/2, x);
        func(n/2, y+n/2, x+n/2);
        cout << ")";
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    string s;
    for(int i=0; i<n; i++){
        string s;
        cin >> s;
        for(int j=0; j<n; j++){
            arr[i][j] = s[j]-'0';
        }
    }
    func(n, 0, 0);
    return 0;
}
