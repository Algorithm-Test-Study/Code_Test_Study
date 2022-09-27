#include <bits/stdc++.h>
using namespace std;
stack<int> s;
vector<char> v;
int n;
int perm[100000];
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  cin >> n;
  for (int i = 0; i < n; i++) cin >> perm[i];
  for (int k = 1, i = 0; k <= n; k++) {
    s.push(k);
    v.push_back('+');
    while (!s.empty() && (s.top() == perm[i])) {
      s.pop();
      v.push_back('-');
      i++;
    }
  }

  if (s.empty())
    for (char c : v) cout << c << '\n';
  else
    cout << "NO" << '\n';
}
