#include <bits/stdc++.h>
using namespace std;

void hanoi(int n, int from, int by, int to){
    if(n == 1) cout << from << " " << to << '\n';
    else{
        hanoi(n-1, from, to, by);               // 기둥 1의 n-1개의 원판을 기둥2로 옮김
        cout << from << " " << to << '\n';      // 기둥1의 1개의 원판을 기둥3으로 옮김
        hanoi(n-1, by, from, to);               // 기둥2의 n-1의 원반을 기둥3으로 옮김
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;
    cout << (int)pow(2, n) - 1 << '\n';
    hanoi(n, 1, 2, 3);

    return 0;
}