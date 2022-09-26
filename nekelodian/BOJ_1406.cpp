#include <bits/stdc++.h>
using namespace std;
int main() {		
  ios::sync_with_stdio(0);	
  cin.tie(0);	
  string str;	
  list<char> editor;
	cin >> str;		

  for(int i=0; i<str.size(); i++){		
    editor.push_back(str.at(i));	
  }			
  int N;	
  list<char>::iterator cursor = editor.end();		
  cin >> N;				
  for(int i=0; i<N; i++){				
    char c;		
    cin >> c;				
    if(c=='L'){			
      if(cursor==editor.begin()) continue;
      else  cursor--;	
    }								
    else if(c=='D'){			
      if(cursor==editor.end())  continue;
      else  cursor++;		
    }					
    else if(c=='B'){			
      if(cursor==editor.begin())  continue;		
      else{  
      	cursor--;
        cursor = editor.erase(cursor);
      }
    }				
    else if(c=='P'){			
      char word;			
      cin >> word;			
      editor.insert(cursor,word);		
    }			
  }
	for(list<char>::iterator it=editor.begin(); it!=editor.end(); it++){		
    cout << *it;	
  }
	return 0;
}
