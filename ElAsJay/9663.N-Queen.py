import sys
n = int(sys.stdin.readline())

row = [0 for _ in range(n)]
ans = 0

def is_avail(x):
    for i in range(x):
        if row[x] == row[i] or abs(row[x] - row[i]) == abs(x - i):
            return False
    return True

def queen(x):
    global ans
    if x == n: # 최종 깊이에 도달 (전부 배치 완료)
        ans += 1
        return
    
    for i in range(n):
        row[x] = i # (x,i)에 퀸을 놓는 경우
        if is_avail(x):
            queen(x+1)

queen(0)
print(ans)