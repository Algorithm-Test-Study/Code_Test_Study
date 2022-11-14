#include <bits/stdc++.h>
using namespace std;

int n;
vector<string> v;

bool cmp(string& a, string& b){
    int a_size = a.size();
    int b_size = b.size();
    int a_sum = 0, b_sum = 0;
    
    if(a_size != b_size)    return a_size < b_size;
    
    for(int i=0; i<a_size; i++){
        if(a[i] >= '0' && a[i] <= '9')  a_sum += a[i] - '0';
    }
    for(int i=0; i<b_size; i++){
        if(b[i] >= '0' && b[i] <= '9')  b_sum += b[i] - '0';
    }
    if(a_sum != b_sum)
        return a_sum < b_sum;
    return a < b;
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> n;
    for(int i=0; i<n; i++){
        string str;
        cin >> str;
        v.push_back(str);
    }
    sort(v.begin(), v.end(), cmp);
    for(auto i : v)
        cout << i << '\n';
    
    return 0;
}
