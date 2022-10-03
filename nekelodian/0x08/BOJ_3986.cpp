#include <bits/stdc++.h>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
  	cin.tie(0);
  
  	int n, cnt=0;
  	cin >> n;
  	while(n--){
	  	string str;
	  	cin >> str;
	  	stack<int> s;
	  	for(auto c : str){
	  		if(s.empty())
	  			s.push(c);
	  		else{
	  			if(s.top() == c){
	  				s.pop();
				}else{
				  	s.push(c);
				}
			}
		}
		if(s.empty())
			cnt++;
  	}
  	cout << cnt;
  	return 0;
}
