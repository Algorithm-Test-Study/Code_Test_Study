#include <bits/stdc++.h>
using namespace std;

int main()
{
    vector<int> alpha(26);
    char str[101];

    cin >> str;
    for(int i=0; i<26; i++)
        alpha[i] = 0;
    for(int i=0; str[i]; i++)
        alpha[str[i]-'a']++;
    for(int i=0; i<26; i++)
        cout << alpha[i] << " ";

    return 0;
}