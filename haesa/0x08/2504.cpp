#include <bits/stdc++.h>
using namespace std;
string str;
stack<char> st;
int result, num = 1;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  cin >> str;
  for (int i = 0; i < str.length(); i++) {
    if (str[i] == '(') {
      num *= 2;
      st.push(str[i]);
    } else if (str[i] == '[') {
      num *= 3;
      st.push(str[i]);
    } else if (str[i] == ')') {
      if (st.empty() || st.top() != '(') {
        cout << 0;
        return 0;
      }
      if (str[i - 1] == '(') result += num;
      st.pop();
      num /= 2;
    } else {
      if (st.empty() || st.top() != '[') {
        cout << 0;
        return 0;
      }
      if (str[i - 1] == '[') result += num;
      st.pop();
      num /= 3;
    }
  }
  if (st.empty())
    cout << result << '\n';
  else
    cout << 0 << '\n';
}