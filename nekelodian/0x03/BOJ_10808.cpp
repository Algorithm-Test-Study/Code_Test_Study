#include <bits/stdc++.h>
using namespace std;
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);

    int freq[26] = {0};
    string a;
    cin >> a;
    for(auto i : a)
        freq[i-'a']++;
    for(int i=0; i<26; i++){
        cout << freq[i] << ' ';
    }
    return 0;
}
