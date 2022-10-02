#include <bits/stdc++.h>
using namespace std;

int main()
{
    int temp, cnt[3];

    for(int i=0; i<3; i++){
        cnt[i] = 0;
        for(int j=0; j<4; j++){
            cin >> temp;
            if(temp == 0) cnt[i]++;
        }
    }
    for(int i=0; i<3; i++){
        if(cnt[i] == 4) cout << "D" << endl;
        else if(cnt[i] == 3) cout <<"C" << endl;
        else if(cnt[i] == 2) cout << "B" << endl;
        else if(cnt[i] == 1) cout << "A" << endl;
        else cout << "E" << endl;
    }

    return 0;
}