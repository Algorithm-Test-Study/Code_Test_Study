#include <bits/stdc++.h>
using namespace std;

int n, result;
string ab;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cin >> n;
  for (int i = 0; i < n; i++) {
    stack<char> word;
    cin >> ab;
    for (char c : ab) {
      if (!word.empty() && word.top() == c)
        word.pop();
      else
        word.push(c);
    }
    if (word.empty()) result++;
  }
  cout << result << '\n';
}