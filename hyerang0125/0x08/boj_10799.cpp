#include <bits/stdc++.h>
using namespace std;

int main()
{

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int sum = 0;
    string str;
    stack<int> pipe;

    cin >> str;
    for(int i=0; i<str.length(); i++){
        if(str[i] == '(') pipe.push(str[i]);
        else{
            pipe.pop();
            if(str[i-1] == '(') sum += pipe.size();
            else sum++;
        }
    }

    cout << sum;

    return 0;
}