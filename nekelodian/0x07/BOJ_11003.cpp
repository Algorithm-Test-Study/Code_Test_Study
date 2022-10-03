#include <bits/stdc++.h>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
  	cin.tie(0);
  
  	deque<pair<int, int>> d;
  	int n, l;
  	cin >> n >> l;

  	for(int i=0; i<n; i++){
  		int num;
  		cin >> num;
  		
		while(!d.empty() && d.back().first >= num)
			d.pop_back();
		d.push_back({num, i});
		
		if(!d.empty()){
  			if(d.front().second < i - l + 1)
  				d.pop_front();
		}
		
		cout << d.front().first << ' ';
	}
  	return 0;
}
