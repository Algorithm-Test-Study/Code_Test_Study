#include <bits/stdc++.h>
using namespace std;

int main()
{
    int list[9] = {0, }, set;
    string n;
    bool flag;

    cin >> n;
    for(int i=0; i<n.length(); i++){
        if(n[i]-'0' == 9) list[6]++;
        else list[n[i]-'0']++;
    }
    set = 0;
    for(int i=0; i<n.length(); i++){
        flag = false;
        for(int j=0; j<9; j++){
            if(j == 6 && (list[6] > 0)){
                flag = true;
                list[j] -= 2;
            } 
            else if(list[j] > 0){
                flag = true;
                list[j]--;
            }
        }
        if(!flag) break;
        set++;
    }
    cout << set;

    return 0;
}