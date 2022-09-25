#include <bits/stdc++.h>
using namespace std;

int main(){
    int n, x;
    cin >> n >> x;

    int result[n];
    for(int i=0; i<n; i++){
        cin >> result[i];
    }
    for(int i=0; i<n; i++){
        if(x > result[i])
            cout << result[i] << " ";
    }
    
    return 0;
}