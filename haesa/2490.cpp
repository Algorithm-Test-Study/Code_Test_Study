#include <iostream>
using namespace std;
int main()
{
  int stick;
  int result;

  for (int i = 0; i < 3; i++)
  {
    result = 0;
    for (int j = 0; j < 4; j++)
    {
      cin >> stick;
      result += stick;
    }
    switch (result)
    {
    case 0:
      cout << 'D' << '\n';
      break;
    case 1:
      cout << 'C' << '\n';
      break;
    case 2:
      cout << 'B' << '\n';
      break;
    case 3:
      cout << 'A' << '\n';
      break;
    case 4:
      cout << 'E' << '\n';
      break;
    }
  }
}