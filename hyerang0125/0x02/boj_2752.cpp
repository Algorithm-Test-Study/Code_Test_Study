#include <bits/stdc++.h>
using namespace std;

int main(){
    int num[3], temp;
    
    cin >> num[0] >> num[1] >> num[2];
    for(int i=0; i<3; i++)
        for(int j=i+1; j<3; j++)
            if(num[i] > num[j]){
                temp = num[i];
                num[i] = num[j];
                num[j] = temp;
            }
    cout << num[0] << " " << num[1] << " " << num[2] << endl;

    return 0;
}