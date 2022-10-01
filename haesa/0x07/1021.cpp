#include <bits/stdc++.h>
using namespace std;
deque<int> dq;
int n, m;
int idx[50];
int num, dq_size;
int result;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  cin >> n >> m;
  for (int i = 0; i < m; i++) cin >> idx[i];
  for (int i = 1; i <= n; i++) dq.push_back(i);
  for (int i = 0; i < m; i++) {
    int k;
    for (k = 0; k < dq.size(); k++)
      if (dq[k] == idx[i]) break;
    dq_size = dq.size();
    if (k < dq_size - k) {
      result += k;
      while (k--) {
        num = dq.front();
        dq.pop_front();
        dq.push_back(num);
      }
    } else {
      k = dq_size - k;
      result += k;
      while (k--) {
        num = dq.back();
        dq.pop_back();
        dq.push_front(num);
      }
    }
    dq.pop_front();
  }
  cout << result << '\n';
}