#include <bits/stdc++.h>
using namespace std;

const int MX = 2000005;
int dat[MX];
int head = 0, tail = 0;

void push(int x){
	dat[tail++] = x;
}

void pop(){
	head++;
}

int front(){
	return dat[head];
}

int back(){
	return dat[tail-1];
}

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n;
    cin >> n;
    while(n--){
    	string s;
    	cin >> s;
    	if(s == "push"){
    		int x;
    		cin >> x;
    		push(x);
		}else if(s == "pop"){
			if(tail != head){
				cout << front() << '\n';
				pop();
			}else{
				cout << "-1\n";
			}
		}else if(s == "size"){
			cout << tail-head << '\n';
		}else if(s == "empty"){
			cout << (tail==head) << '\n';
		}else if(s == "front"){
			if(tail != head)
				cout << front() << '\n';
			else
				cout << "-1\n";
		}else if(s == "back"){
			if(tail != head)
				cout << back() << '\n';
			else
				cout << "-1\n";
		}
	}
    return 0;
}
