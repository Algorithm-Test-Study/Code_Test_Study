#include <bits/stdc++.h>
using namespace std;

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int t;
    cin >> t;
    
    while(t--){
    	deque<int> D;
    	string p, arr;
    	cin >> p;
    	int n;
    	cin >> n;
    	cin >> arr;
    	
    	int j=1;
    	while(arr[j] != '\0'){
    		int num = 0;
    		while(arr[j] >= '0' && arr[j] <= '9'){
    			num *= 10;
    			num += int(arr[j] - '0');
    			j++;
			}
			if(num != 0)	D.push_back(num);
			j++;
		}
    	
    	int flag = 0;
    	bool rev = false;
    	for(int i=0; i<p.size(); i++){
    		if(p[i] == 'R'){
    			rev= !rev;
			}else if(p[i] == 'D'){
				if(D.empty()){
					cout << "error\n";
					flag = 1;
					break;
				}
				if(!rev){
					D.pop_front();
				}else{
					D.pop_back();
				}
			}
			
		}
    	if(!flag){
			if(rev)	reverse(D.begin(), D.end());
			cout << '[';
			for(int i=0; i<D.size(); i++){
				cout << D[i];
				if(i != D.size()-1)
					cout << ',';
			}
			cout << "]\n";
		}
	}
    return 0;
}
