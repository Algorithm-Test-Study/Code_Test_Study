#include <bits/stdc++.h>
using namespace std;
stack<pair<int, int>> tower;
vector<int> result;
int n, h, max_k;
int pos;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  cin >> n;
  tower.push({0, 100000001});
  for (int i = 1; i <= n; i++) {
    cin >> h;
    while (tower.top().second < h) tower.pop();
    cout << tower.top().first << ' ';
    tower.push({i, h});
  }
  cout << '\n';
}
