n = int(input()) # n은 3의 거듭제곱꼴

paper = [list(map(str, input().split())) for _ in range(n)]

counts = [0, 0, 0]

def solution(row, col, n):
    key_num = paper[row][col]
    if n == 0:
        return
    for r in range(row, row + n):
        for c in range(col, col + n):
            if paper[r][c] != key_num:
                for i in range(3):
                    for j in range(3):
                        solution(row + i*(n//3), col + j*(n//3), n//3)
                return
    key_num = int(key_num)
    counts[key_num + 1] += 1

solution(0,0,n)
for c in counts:
    print(c)

