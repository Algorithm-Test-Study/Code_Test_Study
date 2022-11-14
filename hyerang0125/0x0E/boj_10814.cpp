#include <bits/stdc++.h>
using namespace std;
#define age first
#define name second

int n;
pair<int, string> arr[1000001];
pair<int, string> tmp[1000001];

void merge(int st, int en)
{
    int mid = (st + en) / 2;
    int lidx = st;
    int ridx = mid;
    for (int i = st; i < en; i++)
    {
        if (ridx == en)
            tmp[i] = arr[lidx++];
        else if (lidx == mid)
            tmp[i] = arr[ridx++];
        else if (arr[lidx].age <= arr[ridx].age)
            tmp[i] = arr[lidx++];
        else
            tmp[i] = arr[ridx++];
    }
    for (int i = st; i < en; i++)
        arr[i] = tmp[i];
}

void merge_sort(int st, int en)
{
    if (en == st + 1)
        return;
    int mid = (st + en) / 2;
    merge_sort(st, mid);
    merge_sort(mid, en);
    merge(st, en);
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    for (int i = 0; i < n; i++)
        cin >> arr[i].age >> arr[i].name;

    merge_sort(0, n);

    for (int i = 0; i < n; i++)
        cout << arr[i].age << " " << arr[i].name << '\n';

    return 0;
}