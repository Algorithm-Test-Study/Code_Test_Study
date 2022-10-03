#include <bits/stdc++.h>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
  	cin.tie(0);
  
  	int ret = 0;
  	stack<char> s;
  	string str;
  	cin >> str;
  	
  	for(int i=0; i<str.size(); i++){
  		if(str[i] == '(')
  			s.push(str[i]);
  		else{
  			s.pop();
  			if(i!=0 && str[i-1] == '(')
  				ret += s.size();
  			else
  				ret++;
		}
	}
	cout << ret;
  	return 0;
}
