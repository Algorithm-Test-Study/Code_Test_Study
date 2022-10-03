#include <bits/stdc++.h>
using namespace std;

int main()
{
    int t, n;
    string p, list, temp;
    bool error, reverse;

    cin >> t;
    while(t--){
        reverse = error = false;
        deque<string> dq;
        cin >> p;
        cin >> n;
        cin >> list;
        for(int i=1; i<list.length(); i++){
            if(list[i] == ',' || list[i] == ']'){
                if(temp == "") continue;
                dq.push_back(temp);
                temp = "";
            }
            else temp += list[i];
        }

        for(int i=0; i<p.length(); i++){
            switch (p[i])
            {
            case 'R':
                if(reverse) reverse = false;
                else reverse = true;
                break;
            
            case 'D':
                if(dq.empty()){
                    cout << "error\n";
                    error = true;
                }
                else if(reverse) dq.pop_back();
                else dq.pop_front();
                break;

            default:
                break;
            }
            if(error) break;
        }
        if (!error){
            cout << "[";
            if(!reverse && !dq.empty()){
                while(dq.size()>1){
                    cout << dq.front() << ",";
                    dq.pop_front();
                }
                cout << dq.front();         
            }
            else if(reverse && !dq.empty()){
                while (dq.size() > 1){
                    cout << dq.back() << ",";
                    dq.pop_back();
                }
                cout << dq.back();
            }
            cout << "]\n";
        }
    }

    return 0;
}