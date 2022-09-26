#include <bits/stdc++.h>
using namespace std;

int main()
{
    int list[10];
    int a, b, c;
    string num;

    for(int i=0; i<10; i++) list[i]=0;
    cin >> a >> b >> c;
    num = to_string(a * b * c);
    for(int i=0; i<num.length(); i++)
        list[num[i]-'0']++;
    for(int i=0; i<10; i++)
        cout << list[i] << endl;

    return 0;
}