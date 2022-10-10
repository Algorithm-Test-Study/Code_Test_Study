from collections import deque

h, w = map(int, input().split())

#visit = [[0 for _ in range(w)] for _ in range(h)]
graph = [list(map(int, input().split())) for _ in range(h)]

paint = []

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def bfs(graph, a, b):
    queue = deque()
    queue.append([a,b])
    graph[a][b] = 0 # 방문했음을 이렇게 표시 -> 추가적인 메모리 필요X
    cnt = 1

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx <0 or nx >= h or ny <0 or ny>=w:
                continue
            if graph[nx][ny] == 1:
                graph[nx][ny] = 0
                queue.append([nx,ny])
                cnt += 1
    return cnt

for i in range(h):
    for j in range(w):
        if graph[i][j] == 1:
            paint.append(bfs(graph, i, j))

print(len(paint))
if len(paint) == 0:
    print(0)
else:
    print(max(paint))