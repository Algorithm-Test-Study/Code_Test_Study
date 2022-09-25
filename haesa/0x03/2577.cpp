#include <iostream>
using namespace std;
int main() {
  int check[10] = {
      0,
  };
  int a, b, c;
  int result;
  cin >> a >> b >> c;
  result = a * b * c;
  do check[result % 10]++;
  while (result /= 10);
  for (int i = 0; i < 10; i++) cout << check[i] << '\n';
}