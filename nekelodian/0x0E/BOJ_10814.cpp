#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second

int n;
pair<int, string> p[100000];

bool compare(pair<int, string> a, pair<int, string> b){
    return a.X < b.X;
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    for(int i=0; i<n; i++){
        cin >> p[i].X >> p[i].Y;
    }
    stable_sort(p, p+n, compare);
    for(int i=0; i<n; i++)
        cout << p[i].X << ' ' << p[i].Y << '\n';
    return 0;
}
