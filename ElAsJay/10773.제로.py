import sys
stk = []

t = int(sys.stdin.readline())
sum = 0
for _ in range(t):
    n = int(sys.stdin.readline())
    if n == 0:
        if stk:
            sum -= stk.pop()
    else:
        stk.append(n)
        sum += n

print(sum)   