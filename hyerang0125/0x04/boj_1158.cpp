#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n, k, temp;
    queue<int> list;

    cin >> n >> k;
    for(int i=1; i<=n; i++) list.push(i);

    cout << "<";
    while(list.size() > 1){
        for(int i=1; i<k; i++){
            temp = list.front();
            list.pop();
            list.push(temp);
        }
        cout << list.front() << ", ";
        list.pop();
    }
    cout << list.front() << ">\n";
    
    return 0;
}