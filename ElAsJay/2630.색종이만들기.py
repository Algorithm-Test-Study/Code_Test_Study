n = int(input()) # n은 2, 4, 8, 16, 32, 64, 128 중 하나

paper = [list(map(str, input().split())) for _ in range(n)]

color = [0, 0] # 0번 index: 하얀색 / 1번 index: 파란색

def solution(row, col, n):
    key_color = paper[row][col]
    if n == 0:
        return
    for r in range(row, row + n):
        for c in range(col, col + n):
            if paper[r][c] != key_color:
                for i in range(2):
                    for j in range(2):
                        solution(row + i*(n//2), col + j*(n//2), n//2)
                return
    key_color = int(key_color)
    color[key_color] += 1

solution(0,0,n)
for count in color:
    print(count)