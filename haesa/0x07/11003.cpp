#include <bits/stdc++.h>
using namespace std;
deque<pair<int, int>> dq;

int n, l, num;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  cin >> n >> l;
  for (int i = 0; i < n; i++) {
    cin >> num;
    if (!dq.empty() && dq.front().second + l == i) dq.pop_front();
    while (!dq.empty() && dq.back().first >= num) dq.pop_back();
    dq.push_back({num, i});
    cout << dq.front().first << ' ';
  }
}
