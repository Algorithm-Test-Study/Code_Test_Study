#include <bits/stdc++.h>
using namespace std;
int n, k, len=0;
int pre[5001];
int nxt[5001];
vector<int> v;

int main(void){
	ios::sync_with_stdio(0);
	cin.tie(0);
	
	cin >> n >> k;
	cout << '<';
	
	for(int i=1; i<=n; i++){
		if(i == 1)	pre[i] = n;
		else	pre[i] = i-1;
		if(i == n)	nxt[i] = 1;
		else	nxt[i] = i+1;
		len++;
	}
	
	for(int i=1, cursor=1; len!=0; cursor = nxt[cursor]){
		if(i == k){
			v.push_back(cursor);
			pre[nxt[cursor]] = pre[cursor];
			nxt[pre[cursor]] = nxt[cursor];
			len--;
			i=1;
		}
		else	i++;
	}
	
	for(int i=0; i<v.size(); i++){
		cout << v[i];
		if(i == v.size()-1)	break;
		cout << ", ";
	}
	cout << '>';
	return 0;
}
