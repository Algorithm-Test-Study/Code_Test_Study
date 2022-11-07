#include <bits/stdc++.h>
using namespace std;

int n;
int paper[129][129];
int blue, white;

void cut(int x, int y, int size){
    int check = paper[x][y];
    for(int i=x; i<x+size; i++){
        for(int j=y; j<j+size; j++){
            if (check != paper[i][j]){
                cut(x, y, size/2);
                cut(x, y + size / 2, size / 2);
                cut(x+size / 2, y, size/2);
                cut(x+size / 2, y+size / 2, size/2);
                return ;
            }
        }
        if(check == 1) blue++;
        else white++;
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++)
            cin >> paper[i][j];
    }

    cut(0, 0, n);
    cout << white << endl;
    cout << blue << endl;


    return 0;
}