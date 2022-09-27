#include <iostream>
#include <stack>
using namespace std;
stack<int> money;
int k;
int n;
int total;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  cin >> k;
  for (int i = 0; i < k; i++) {
    cin >> n;
    (n == 0) ? money.pop() : money.push(n);
  }
  n = money.size();
  for (int i = 0; i < n; i++) {
    total += money.top();
    money.pop();
  }
  cout << total;
}
