#include <iostream>
using namespace std;
int main()
{
  int n, order;
  int max = 0;
  for (int i = 0; i < 9; i++)
  {
    cin >> n;

    if (max < n)
    {
      max = n;
      order = i + 1;
    }
  }
  cout << max << '\n';
  cout << order << '\n';
}