#include <bits/stdc++.h>
using namespace std;

int n;
int video[65][65];

void quadtree(int x, int y, int size)
{
    if(size == 1){
        cout << video[x][y];
        return;
    }
    bool checkZ = true, checkO = true;
    for (int i = x; i < x + size; i++)
    {
        for (int j = y; j < y + size; j++)
        {
            if (video[i][j]) checkO = false;
            else checkZ = false;
            if(!checkO && !checkZ){
                cout << "(";
                quadtree(x, y, size / 2);
                quadtree(x, y + size / 2, size / 2);
                quadtree(x + size / 2, y, size / 2);
                quadtree(x + size / 2, y + size / 2, size / 2);
                cout << ")";
                return ;
            }
        }
    }
    cout << video[x][y];
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    string temp;

    cin >> n;
    for (int i = 0; i < n; i++)
    {
        cin >> temp;
        for (int j = 0; j < n; j++)
            video[i][j] = temp[j] - '0';
    }

    quadtree(0, 0, n);

    return 0;
}