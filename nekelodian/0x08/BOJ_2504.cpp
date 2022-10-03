#include <bits/stdc++.h>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
  	cin.tie(0);
  
  	int ret = 0, tmp = 1;
  	stack<char> s;
  	string str;
  	cin >> str;
  	
  	for(int i=0; i<str.size(); i++){
  		if(str[i] == '('){
  			tmp *= 2;
  			s.push(str[i]);
		}
  		else if(str[i] == '['){
  			tmp *= 3;
  			s.push(str[i]);
		}else if(str[i] == ')'){
			if(s.empty() || s.top() != '('){
				cout << 0;
				return 0;
			}else{
				if(i==0 || str[i-1] == '(')
					ret += tmp;
				tmp /= 2;
				s.pop();
			}
		}else if(i==0 || str[i] == ']'){
			if(s.empty() || s.top() != '['){
				cout << 0;
				return 0;
			}
			if(str[i-1] == '[')
				ret += tmp;
			tmp /= 3;
			s.pop();
		}
	}
	if(!s.empty())
		cout << 0;
	else
		cout << ret;
  	return 0;
}
