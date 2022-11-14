#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    int nlist[1000];

    cin >> n;
    for(int i=0; i<n; i++)
        cin >> nlist[i];
    
    for(int i=0; i<n; i++){
        for(int j=i+1; j<n; j++){
            if(nlist[i] > nlist[j])
                swap(nlist[i], nlist[j]);
        }
    }

    for(int i=0; i<n; i++)
        cout << nlist[i] << endl;

    return 0;
}