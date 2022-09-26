#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n, sum, min;

    sum = 0, min = 100;
    for(int i=0; i<7; i++){
        cin >> n;
        if(n%2 != 0){
            sum += n;
            if(min > n) min = n;
        }
    }

    if(sum == 0) cout << -1;
    else{
        cout << sum << endl;
        cout << min << endl;
    }

    return 0;
}