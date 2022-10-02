#include <bits/stdc++.h>
using namespace std;
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    deque<int> D;
    int n, m;
    cin >> n >> m;
    for(int i=1; i<=n; i++)	D.push_back(i);
    int cnt = 0, mid;
    
    while(m--){
    	int x;
    	cin >> x;
    	if(x == D.front()){
    		if(!D.empty())
	    		D.pop_front();
		}else{
			int idx = find(D.begin(), D.end(), x) - D.begin();
			mid = n%2 == 0 ? n/2-1 : n/2;
			if(idx <= mid){	//2번 연산 
	    		while(x != D.front()){
	    			D.push_back(D.front());
	    			D.pop_front();
	    			cnt++;
				}	
			}else{		//3번 연산  
				while(x != D.front()){
					D.push_front(D.back());
					D.pop_back();
					cnt++;
				}
			}
			D.pop_front();
		}
		n--;
	}
	cout << cnt;
    return 0;
}
