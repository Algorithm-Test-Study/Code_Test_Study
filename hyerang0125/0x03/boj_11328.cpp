#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n, alpha[26];
    string str1, str2;
    vector<string> result;
    bool flag;

    cin >> n;
    for(int i=0; i<n; i++){
        flag = true;
        for(int i=0; i<26; i++)
            alpha[i] = 0;

        cin >> str1 >> str2;
        if(str1.length() != str2.length()){
            result.push_back("Impossible");
            continue;
        }

        for(int j=0; j<str1.length(); j++)
            alpha[str1[j]-'a']++;
        for(int j=0; j<str2.length(); j++)
            alpha[str2[j] - 'a']--;
        for(int j=0; j<26; j++){
            if(alpha[j] != 0){
                flag = false;
                break;
            }
        }
        
        if(flag) result.push_back("Possible");
        else result.push_back("Impossible");
    }
    for(int i=0; i<n; i++)
        cout << result[i] << endl;

    return 0;
}