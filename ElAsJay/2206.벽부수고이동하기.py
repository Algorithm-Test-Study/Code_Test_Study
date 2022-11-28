from collections import deque

# 0. input
n,m = map(int, input().split())
maze = [list(map(int, input().strip())) for _ in range(n)]
# visited[x][y][carsh]
# crash: 0 = 벽을 뚫을 수 없음 / 1 = 벽을 뚫을 수 있음
visited = [[[0, 0] for _ in range(m)] for _ in range(n)]

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

# 1. search
def move(start_x, start_y, is_crash):
    global visited, maze
    queue = deque()
    queue.append((start_x, start_y, is_crash))
    visited[start_x][start_y][is_crash] = 1
    while queue:
        x, y, crash = queue.popleft()
        if x == n-1 and y == m-1:
            return visited[x][y][crash]
        for i in range(4):
            next_x = x + dx[i]
            next_y = y + dy[i]
            if 0 <= next_x < n and 0 <= next_y < m:
                # 다음 좌표에 벽이 있고, 현재 위치에서 벽을 뚫을 수 있는 상태일 때
                if maze[next_x][next_y] == 1 and crash == 1:
                    visited[next_x][next_y][0] = visited[x][y][1] + 1
                    queue.append((next_x, next_y, 0))
                # 다음 좌표는 벽이 없고, 한 번도 지나가지 않은 길일 때 (벽을 뚫지 않으므로 crash 그대로 유지)
                elif maze[next_x][next_y] == 0 and visited[next_x][next_y][crash] == 0:
                    visited[next_x][next_y][crash] = visited[x][y][crash] + 1
                    queue.append((next_x, next_y, crash))
    return -1

# 2. print
print(move(0,0,1))
