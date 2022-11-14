#include <bits/stdc++.h>
using namespace std;

bool str_cmp(const string& A, const string& B){
    int A_size = A.size(), B_size = B.size();
    if(A_size != B_size) return A_size < B_size;

    int A_sum, B_sum;
    A_sum = B_sum = 0;
    for(int idx = 0; idx<A_size; idx++){
        if('0' <= A[idx] && A[idx] <= '9')
            A_sum += A[idx] - '0';
        if ('0' <= B[idx] && B[idx] <= '9')
            B_sum += B[idx] - '0';
    }
    if(A_sum != B_sum) return A_sum < B_sum;

    return A<B;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    string str_input[1001];

    cin >> n;
    for (int i = 0; i < n; i++){
        cin >> str_input[i];
    }
    sort(str_input, str_input + n, str_cmp);

    for (int i = 0; i < n; i++){
        cout << str_input[i] << '\n';
    }

    return 0;
}