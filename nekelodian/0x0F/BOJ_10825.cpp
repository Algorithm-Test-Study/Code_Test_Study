#include <bits/stdc++.h>
using namespace std;

struct Student{
    string name;
    int kor, eng, math;
};
vector<Student> s;

bool cmp(Student &a, Student &b){
    if(a.kor == b.kor){
        if(a.eng == b.eng){
            if(a.math == b.math){
                return a.name < b.name;
            }
            return a.math > b.math;
        }
        return a.eng < b.eng;
    }
    return a.kor > b.kor;
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int n;
    cin >> n;
    for(int i=0; i<n; i++){
        Student a;
        cin >> a.name >> a.kor >> a.eng >> a.math;
        s.push_back(a);
    }
    sort(s.begin(), s.end(), cmp);
    for(auto i : s){
        cout << i.name << '\n';
    }
    return 0;
}
