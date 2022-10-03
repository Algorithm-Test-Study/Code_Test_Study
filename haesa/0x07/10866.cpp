#include <bits/stdc++.h>
using namespace std;
deque<int> dq;
int n, k;
string cmd;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> cmd;
    if (cmd == "push_front") {
      cin >> k;
      dq.push_front(k);
    } else if (cmd == "push_back") {
      cin >> k;
      dq.push_back(k);
    } else if (cmd == "pop_front") {
      if (dq.empty())
        cout << -1 << '\n';
      else {
        cout << dq.front() << '\n';
        dq.pop_front();
      }
    } else if (cmd == "pop_back") {
      if (dq.empty())
        cout << -1 << '\n';
      else {
        cout << dq.back() << '\n';
        dq.pop_back();
      }
    } else if (cmd == "size")
      cout << dq.size() << '\n';
    else if (cmd == "empty")
      cout << dq.empty() << '\n';
    else if (cmd == "front") {
      if (dq.empty())
        cout << -1 << '\n';
      else
        cout << dq.front() << '\n';
    } else if (cmd == "back") {
      if (dq.empty())
        cout << -1 << '\n';
      else
        cout << dq.back() << '\n';
    }
  }
}
