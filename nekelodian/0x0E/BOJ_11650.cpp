#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second

int n;
pair<int, int> p[100000];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    for(int i=0; i<n; i++)
        cin >> p[i].X >> p[i].Y;
    sort(p, p+n);
    for(int i=0; i<n; i++)
        cout << p[i].X << ' ' << p[i].Y << '\n';
    return 0;
}
