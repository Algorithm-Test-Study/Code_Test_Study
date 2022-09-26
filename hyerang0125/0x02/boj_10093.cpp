#include <bits/stdc++.h>
using namespace std;

int main()
{
    long long a, b;

    cin >> a >> b;
    if(a>b){
        cout << a-b-1 << endl;
        for (long long i = b + 1; i < a; i++)
            cout << i << " ";
    }
    else if(a<b){
        cout << b-a-1 << endl;
        for (long long i = a + 1; i < b; i++)
            cout << i << " ";
    }
    else cout << "0" << endl;

    return 0;
}