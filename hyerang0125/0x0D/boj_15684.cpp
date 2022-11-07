#include <bits/stdc++.h>

using namespace std;

int ladder[32][32] = {0};
int n, m, h;

// 조건이 맞는지 검사하는 함수
bool isAnswer()
{
    int now, right, left;
    for (int i = 1; i <= n; i++)
    {
        now = i;
        for (int j = 1; j <= h; j++)
        {
            left = ladder[j][now - 1];
            right = ladder[j][now];

            if (left)
                --now;
            if (right)
                ++now;
        }
        if (now != i)
            return false;
    }
    return true;
}

// 사다리를 추가하며 확인하는 함수
int dfs(int end, int depth, int _row, int _col)
{
    // 깊이가(추가하는 사다리 수가) end와 같다면 검사하고 맞으면 출력 아니면 다시 탐색
    if (depth == end)
    {
        if (isAnswer())
        {
            cout << depth;
            exit(0);
        }
        return 0;
    }
    for (int row = _row; row <= h; row++)
    {
        for (int col = 1; col <= n; col++)
        {
            if (ladder[row][col - 1] || ladder[row][col] || ladder[row][col + 1])
                continue;
            ladder[row][col] = 1;
            dfs(end, depth + 1, row, col);
            ladder[row][col] = 0;
        }
    }
    return 0;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int temp1, temp2;

    cin >> n >> m >> h;
    for (int i = 0; i < m; i++)
    {
        cin >> temp1 >> temp2;
        ladder[temp1][temp2] = 1;
    }
    if (isAnswer())
    {
        cout << "0";
        return 0;
    }
    // 추가하는 가로선 개수가 3보다 큰 값이면 -1을 출력해야 하므로 end 조건으로 사용 할 예정
    for (int cnt = 1; cnt <= 3; cnt++)
    {
        for (int row = 1; row <= h; row++)
        {
            for (int col = 1; col <= n; col++)
            {
                // 이미 사다리가 있다면 pass
                if (ladder[row][col - 1] || ladder[row][col] || ladder[row][col + 1])
                    continue;
                // dfs 탐색
                ladder[row][col] = 1;
                dfs(cnt, 1, row, col);
                ladder[row][col] = 0;
            }
        }
    }
    // 정답이 3보다 큰 값이거나 불가능 한 경우이므로 -1을 출력
    cout << "-1";

    return 0;
}