#include <bits/stdc++.h>
using namespace std;
stack<char> L, R;

int main() {		
  	ios::sync_with_stdio(0);	
  	cin.tie(0);	
  	
  	int tc;
  	cin >> tc;
  	
  	for(int i=0; i<tc; i++){
  		string str;
  		cin >> str;
  		
		list<char> key = {};
  		auto cursor = key.begin();
  		
		for(char c : str){
			if(c=='<'){
		      	if(cursor==key.begin()) continue;
		      	else  cursor--;	
		    }
		    else if(c=='>'){
		      	if(cursor==key.end())  continue;
		      	else  cursor++;	
		    }
		    else if(c=='-'){			
		      	if(cursor==key.begin())  continue;		
		      	else{  
		      		cursor--;
		        	cursor = key.erase(cursor);
		      	}
		    }
	    	else{						
	      		key.insert(cursor, c);
	    	}
		}
		
		for(char c : key)	cout << c;
		cout << "\n";
	  	 		
  	}
	return 0;
}
