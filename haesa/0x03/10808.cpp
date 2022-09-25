#include <iostream>
#include <string>
using namespace std;
int main() {
  char alpha[26] = {};
  string str;
  cin >> str;
  for (char c : str) alpha[c - 'a']++;
  for (int value : alpha) cout << value << ' ';
}