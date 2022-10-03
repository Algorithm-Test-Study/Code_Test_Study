#include <bits/stdc++.h>
using namespace std;
queue<int> q;
int n;
int card;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  cin >> n;
  for (int i = 1; i <= n; i++) q.push(i);
  for (int i = 0; i < n - 1; i++) {
    q.pop();
    card = q.front();
    q.pop();
    q.push(card);
  }
  cout << q.front() << '\n';
}
