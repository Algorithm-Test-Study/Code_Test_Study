from collections import deque

n, m = map(int, input().split())
num = deque([i for i in range(1, n+1)])

tar = list(map(int, input().split())) # a, b, c -> num의 a, b, c 찾으면 됨

cnt = 0

for i in range(m):
    k = tar[i]

    while True:
        head = num[0]
        tail = num[-1]
        if k == head:
            num.popleft()
            break
        else:
            idx = num.index(k)
            if idx < len(num)/2:
                num.append(num.popleft())
                cnt += 1
            else:
                num.appendleft(num.pop())
                cnt += 1


print(cnt)