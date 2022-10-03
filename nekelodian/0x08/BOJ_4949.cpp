#include <bits/stdc++.h>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  
  while(true){
    string str;
    getline(cin, str);
    if(str == ".") break;
    
    stack<char> S;
    int flag = 1;
    
    for(int i=0; i<str.size(); i++){
      if(str[i] == '(' || str[i] == '[') S.push(str[i]);
      else if(str[i] == ')'){
        if(S.empty() || S.top() != '('){
          flag = 0;
          break;
        }
        S.pop();
      }
      else if(str[i] == ']'){
        if(S.empty() || S.top() != '['){
          flag = 0;
          break;
        }
        S.pop();
      }
    }
    if(!S.empty()) flag = 0;
    if(flag) cout << "yes\n";
    else cout << "no\n";
  }
}
