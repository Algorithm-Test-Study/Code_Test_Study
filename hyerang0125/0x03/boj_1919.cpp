#include <bits/stdc++.h>
using namespace std;

int main()
{
    int alpha[26] = {0, };
    int remove = 0;
    string str1, str2;

    cin >> str1 >> str2;
    for(int i=0; i<str1.length(); i++)
        alpha[str1[i] -'a']++;
    for(int i=0; i<str2.length(); i++)
        alpha[str2[i]-'a']--;

    for(int i=0; i<26; i++){
        if(alpha[i] != 0)
            remove += abs(alpha[i]);
    }

    cout << remove;

    return 0;
}