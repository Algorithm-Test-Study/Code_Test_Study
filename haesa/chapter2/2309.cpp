#include <algorithm>
#include <iostream>
using namespace std;
int main() {
  int total = 0;
  int n[9];
  for (int i = 0; i < 9; i++) {
    cin >> n[i];
    total += n[i];
  }

  sort(n, n + 9);

  int sub = total - 100;
  for (int i = 0; i < 9; i++) {
    for (int j = i + 1; j < 9; j++)
      if (n[i] + n[j] == sub) {
        for (int k = 0; k < 9; k++) {
          if (k == i || k == j) continue;
          cout << n[k] << '\n';
        }
        return 0;
      }
  }
}