#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n, k, s, g, room;
    int list[2][6] = {0, };

    cin >> n >> k;
    for(int i=0; i<n; i++){
        cin >> s >> g;
        list[s][g-1]++;
    }

    room = 0;
    for(int i=0; i<2; i++){
        for(int j=0; j<6; j++){
            while(list[i][j] > 0){
                list[i][j] -= k;
                room++;
            }
        }
    }

    cout << room;

    return 0;
}