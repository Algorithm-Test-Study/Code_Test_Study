import sys

n = int(sys.stdin.readline())
t = list(map(int, sys.stdin.readline().split()))
stk = []
result = [0 for _ in range(n)]

for idx, val in enumerate(t):
    while stk:
        if stk[-1][1] > val:
            result[idx] = stk[-1][0] + 1
            break
        else: # stk의 가장 마지막 idx의 value 값이 현재의 val보다 작거나 같은 경우
            stk.pop()
    stk.append([idx, val])

for x in result:
    print(x, end=" ")