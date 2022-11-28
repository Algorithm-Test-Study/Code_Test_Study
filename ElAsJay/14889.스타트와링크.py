import sys
input = sys.stdin.readline

n = int(input())
s = [list(map(int, input().split())) for _ in range(n)]

start = []
link = []
min_diff = float('Inf') # 무한대

def dfs(idx):
    global min_diff
    if idx == n//2:
        sum_start = sum_link = 0
        for i in range(n):
            if i not in start:
                link.append(i)
        
        for i in range(0, n//2 - 1):
            for j in range(i+1, n//2):
                sum_start += (s[start[i]][start[j]] + s[start[j]][start[i]])
                sum_link += (s[link[i]][link[j]] + s[link[j]][link[i]])
            
        diff = abs(sum_start - sum_link)
        if diff < min_diff:
            min_diff = diff
        link.clear()

    for i in range(n):
        if i in start:
            continue
        if len(start) > 0 and start[len(start)-1] > i:
            continue
        start.append(i)
        dfs(idx + 1)
        start.pop()

dfs(0)
print(min_diff)