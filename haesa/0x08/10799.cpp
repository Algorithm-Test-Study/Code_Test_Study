#include <bits/stdc++.h>
using namespace std;
string str;
stack<char> st;
int result;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  cin >> str;
  for (int i = 0; i < str.length(); i++) {
    if (str[i] == '(')
      st.push('(');
    else {
      st.pop();
      if (str[i - 1] == '(')
        result += st.size();
      else
        result++;
    }
  }
  cout << result << '\n';
}