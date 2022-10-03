#include <bits/stdc++.h>
using namespace std;

int main()
{
    int k, num, sum;
    stack<int> s;

    cin >> k;
    for(int i=0; i<k; i++){
        cin >> num;
        if(num == 0){
            if(s.empty()) continue;
            else s.pop();
        }
        else{
            s.push(num);
        }
    }

    sum = 0;
    while(!s.empty()){
        sum += s.top();
        s.pop();
    }

    cout << sum << endl;

    return 0;
}