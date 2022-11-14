#include <bits/stdc++.h>
using namespace std;
#define age first
#define name second

int n;
int freq[2000001];

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    for(int i=0; i<n; i++){
        int a;
        cin >> a;
        freq[a+1000000]++;
    }
    for(int i=0; i<=2000000; i++){
        while(freq[i]--)
            cout << i - 1000000 << '\n';
        }

    return 0;
}