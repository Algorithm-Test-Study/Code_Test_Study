#include <cmath>
#include <iostream>
#include <string>
using namespace std;
int main() {
  int digit[10] = {};
  int max = 0;
  string str;
  cin >> str;
  for (char c : str) digit[c - '0']++;
  for (int i = 0; i < 9; i++) {
    if (i == 6) continue;
    (max < digit[i]) && (max = digit[i]);
  }
  double sixnine = ceil((double)(digit[6] + digit[9]) / 2);
  (max < sixnine) && (max = sixnine);
  cout << max;
}