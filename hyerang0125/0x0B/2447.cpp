#include <bits/stdc++.h>
using namespace std;

void draw(int len, int row, int col){
    if ((row / len) % 3 == 1 && (col / len) % 3 == 1)
        cout << ' ';
    else{
        if(len / 3 == 0) cout << '*';
        else draw(len / 3, row, col);
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++)
            draw(n, i, j);
        cout << endl;
    }

    return 0;
}