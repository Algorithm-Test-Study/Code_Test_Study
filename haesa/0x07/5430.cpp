#include <bits/stdc++.h>
using namespace std;

void parse(string& arr, deque<int>& dq) {
  int num = 0;
  for (int i = 1; i + 1 < arr.size(); i++) {
    if (arr[i] == ']') break;
    if (arr[i] >= '0' && arr[i] <= '9')
      num = num * 10 + (arr[i] - '0');
    else {
      dq.push_back(num);
      num = 0;
    }
  }
  if (num != 0) dq.push_back(num);
}

void print_deque(deque<int>& dq) {
  cout << '[';
  for (int j = 0; j < dq.size(); j++)
    cout << dq[j] << (j + 1 != dq.size() ? "," : "");
  cout << ']' << '\n';
}

int t, n;
string p, arr;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  cin >> t;
  for (int i = 0; i < t; i++) {
    deque<int> dq;
    int rev = 0;
    int error = 0;
    cin >> p >> n >> arr;
    parse(arr, dq);

    for (char f : p) {
      if (f == 'R')
        rev = 1 - rev;
      else {
        if (dq.empty()) {
          error = 1;
          break;
        }
        if (rev)
          dq.pop_back();
        else
          dq.pop_front();
      }
    }
    if (error)
      cout << "error" << '\n';
    else {
      if (rev) reverse(dq.begin(), dq.end());
      print_deque(dq);
    }
  }
}