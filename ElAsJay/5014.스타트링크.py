from collections import deque

# 총 F층 / 현재 S층 / 목표 G층 / 위로 U층 / 아래로 D층
f, s, g, u, d = map(int, input().split())
visited = [0 for _ in range(f+1)]
cnt_arr = [0 for _ in range(f+1)]

def bfs(s):
    queue = deque([s])
    visited[s] = 1
    while queue:
        tmp = queue.popleft()
        if tmp == g:
            return cnt_arr[g]
        for i in (tmp+u, tmp-d):
            if 0< i <=f and not visited[i]:
                visited[i] = 1
                cnt_arr[i] = cnt_arr[tmp] + 1
                queue.append(i)
        
    if cnt_arr[g] == 0:
        return "use the stairs"

print(bfs(s))