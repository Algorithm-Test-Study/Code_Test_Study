#include <bits/stdc++.h>

using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n;
    cin >> n;
    int arr[n] = {0};
    for(int i=0; i<n; i++)
        cin >> arr[i];
    for(int i=0; i<n; i++){
        for(int j=0; j<n-1-i; j++){
            if(arr[j] > arr[j+1])   swap(arr[j], arr[j+1]);
        }
    }
    for(int i=0; i<n; i++)
        cout << arr[i] << '\n';
    return 0;
}
