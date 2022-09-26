#include <iostream>
#include <list>
#include <string>
using namespace std;
list<char> l;
list<char>::iterator t;
string s;
int n;
char cmd;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  cin >> s;
  for (char c : s) l.push_back(c);
  t = l.end();
  cin >> n;
  cin.ignore();

  for (int i = 0; i < n; i++) {
    cin >> cmd;
    switch (cmd) {
      case 'L':
        if (t != l.begin()) t--;
        break;
      case 'D':
        if (t != l.end()) t++;
        break;
      case 'B':
        if (t == l.begin()) continue;
        if (t == l.end()) {
          l.erase(--t);
          t = l.end();
        } else
          t = l.erase(--t);
        break;
      case 'P':
        cin >> cmd;
        l.insert(t, cmd);
    }
  }
  for (auto i : l) cout << i;
}