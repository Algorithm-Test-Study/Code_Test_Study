#include <bits/stdc++.h>
using namespace std;

int S[13];
int lotto[6];
int k;

void C(int start, int depth){
    if(depth == 6){
        for(int i=0; i<6; i++)
            cout << lotto[i] << " ";
        cout << endl;
        return ;
    }
    for(int i=start; i<k; i++){
        lotto[depth] = S[i];
        C(i+1, depth+1);
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    while(cin >> k){
        if(k == 0) break;
        for(int i=0; i<k; i++){
            cin >> S[i];
        }
        C(0, 0);
        cout << endl;
    }

    return 0;
}