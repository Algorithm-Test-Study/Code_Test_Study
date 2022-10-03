#include <bits/stdc++.h>
using namespace std;
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    deque<int> D;
    int n;
    cin >> n;
    while(n--){
    	string s;
    	cin >> s;
    	if(s == "push_front"){
    		int x;
    		cin >> x;
    		D.push_front(x);
		}else if(s == "push_back"){
			int x;
			cin >> x;
			D.push_back(x);
		}else if(s == "pop_front"){
			if(D.empty())
				cout << -1 << '\n';
			else{
				cout << D.front() << '\n';
				D.pop_front();
			}
		}else if(s == "pop_back"){
			if(D.empty())
				cout << -1 << '\n';
			else{
				cout << D.back() << '\n';
				D.pop_back();
			}
		}else if(s == "size"){
			cout << D.size() << '\n';
		}else if(s == "empty"){
			if(D.empty())
				cout << 1 << '\n';
			else
				cout << 0 << '\n';
		}else if(s == "front"){
			if(D.empty())
				cout << -1 << '\n';
			else
				cout << D.front() << '\n';
		}else{
			if(D.empty())
				cout << -1 << '\n';
			else
				cout << D.back() << '\n';
		}
	}
    return 0;
}
