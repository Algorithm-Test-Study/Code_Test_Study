#include <iostream>
#include <list>
#include <string>
using namespace std;
string input;

int n;
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> input;
    list<char> l;
    list<char>::iterator t = l.end();
    for (char c : input) {
      switch (c) {
        case '<':
          if (t == l.begin()) continue;
          t--;
          break;
        case '>':
          if (t == l.end()) continue;
          t++;
          break;
        case '-':
          if (t == l.begin()) continue;
          if (t == l.end()) {
            l.erase(--t);
            t = l.end();
          } else
            t = l.erase(--t);
          break;
        default:
          l.insert(t, c);
      }
    }
    for (char c : l) cout << c;
    cout << '\n';
  }
}