#include <bits/stdc++.h>
using namespace std;
queue<int> q;
string cmd;
int n, k;
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> cmd;
    if (cmd == "push") {
      cin >> k;
      q.push(k);
    } else if (cmd == "pop") {
      if (q.empty())
        cout << -1 << '\n';
      else {
        cout << q.front() << '\n';
        q.pop();
      }
    } else if (cmd == "size")
      cout << q.size() << '\n';
    else if (cmd == "empty")
      cout << q.empty() << '\n';
    else if (cmd == "front") {
      if (q.empty())
        cout << -1 << '\n';
      else
        cout << q.front() << '\n';
    } else if (cmd == "back") {
      if (q.empty())
        cout << -1 << '\n';
      else
        cout << q.back() << '\n';
    }
  }
}
