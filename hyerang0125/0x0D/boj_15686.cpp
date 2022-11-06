#include <bits/stdc++.h>
using namespace std;

int n, m;
int board[55][55];
vector<pair<int, int>> chicken;
vector<pair<int, int>> house;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n >> m;
    for(int i=0; i<n; i++)
        for(int j=0; j<n; j++){
            cin >> board[i][j];
            if(board[i][j] == 1) house.push_back(make_pair(i, j));
            if(board[i][j] == 2) chicken.push_back(make_pair(i, j));
        }

    vector<int> brute(chicken.size(), 1);
    fill(brute.begin(), brute.begin() + chicken.size()-m, 0);
    int mn = 0x7f7f7f7f;
    do{
        int dist = 0;
        for(auto h : house){
            int tmp = 0x7f7f7f7f;
            for(int i=0; i<chicken.size(); i++){
                if(brute[i] == 0) continue;
                tmp = min(tmp, abs(chicken[i].first - h.first) + abs(chicken[i].second - h.second));
            }
            dist += tmp;
        }
        mn = min(mn, dist);
    }while(next_permutation(brute.begin(), brute.end()));
    cout << mn;

    return 0;
}