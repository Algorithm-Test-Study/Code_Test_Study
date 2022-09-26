#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n, sum = 0;
    vector<int> list9;

    for(int i=0; i<9; i++){
        cin >> n;
        list9.push_back(n);
        sum += n;
    }
    sum -= 100;
    for(int i=0; i<9; i++){
        for(int j=i+1; j<9; j++){
            if(list9[i] + list9[j] == sum){
                list9[i] = list9[j] = 0;
                sum = 100;
                break;
            }
        }
        if (sum == 100)  break;
    }
    sort(list9.begin(), list9.end());
    for(int i=2; i<9; i++){
        cout << list9[i] << endl;
    }

    return 0;
}