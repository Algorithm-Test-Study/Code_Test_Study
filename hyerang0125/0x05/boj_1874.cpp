#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n, x, top(0);
    stack<int> s;
    string result;

    cin >> n;
    top = 0, result = "";
    while(n--){
        cin >> x;
        if(x > top){
            for(int i=top+1; i<=x; i++){
                s.push(i);
                result += "+";
            }
        }
        else{
            if(s.top() != x){
                cout << "NO";
                return 0;
            }
        }
        s.pop();
        result += "-";
        if(x > top) top = x;
    }
    
    for(int i=0; i<result.length(); i++)
        cout << result[i] << "\n";

    return 0;
}