#include <algorithm>
#include <iostream>
using namespace std;
int a[100000];
bool check[2000001] = {};
int n, x;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int result = 0;
  cin >> n;
  for (int i = 0; i < n; i++) cin >> a[i];
  cin >> x;
  for (int i = 0; i < n; i++) {
    if (x > a[i] && check[x - a[i]]) result++;
    check[a[i]] = 1;
  }
  cout << result;
}