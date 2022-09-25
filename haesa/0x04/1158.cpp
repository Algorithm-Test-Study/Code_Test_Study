#include <bits/stdc++.h>
using namespace std;
list<int> perm;
vector<int> result;
int n, k;
int main() {
  cin >> n >> k;
  for (int i = 1; i <= n; i++) perm.push_back(i);
  for (list<int>::iterator addr = perm.begin(); perm.empty() != true;) {
    for (int i = 0; i < k - 1; i++) {
      addr++;
      if (addr == perm.end()) addr = perm.begin();
    }
    result.push_back(*addr);
    if ((addr = perm.erase(addr)) == perm.end()) addr = perm.begin();
  }
  cout << '<';
  for (int i = 0; i < result.size() - 1; i++) cout << result[i] << ", ";
  cout << result[result.size() - 1] << '>' << '\n';
}