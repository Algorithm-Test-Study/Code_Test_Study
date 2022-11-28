#include <bits/stdc++.h>
using namespace std;

class Student{
    private:
        string name;
        int korean;
        int english;
        int mathematics;
    public:
        Student(string name, int korean, int english, int mathematics);
        static bool cmp(Student &a, Student &b);
        string getName();
};

Student::Student(string name, int korean, int english, int mathematics){
    this->name = name; this->korean = korean; this->english = english; this->mathematics = mathematics;
}
bool Student::cmp(Student &a, Student &b){
    if(a.korean == b.korean && a.english == b.english && a.mathematics == b.mathematics)
        return a.name < b.name;
    if (a.korean == b.korean && a.english == b.english) return a.mathematics > b.mathematics;
    else if (a.korean == b.korean) return a.english < b.english;
    return a.korean > b.korean;
}
string Student::getName(){
    return this->name;
}


int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string name;
    int sc1, sc2, sc3;
    int n;
    cin >> n;
    vector<Student> v;

    for(int i=0; i<n; i++){
        cin >> name >> sc1 >> sc2 >> sc3;
        Student temp(name, sc1, sc2, sc3);
        v.push_back(temp);
    }

    sort(v.begin(), v.end(), Student::cmp);

    for(int i=0; i<v.size(); i++){
        cout << v[i].getName() << '\n';
    }

    return 0;
}