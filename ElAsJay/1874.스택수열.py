import sys

n = int(sys.stdin.readline())
stk = []
cur = 1
result = []
flag = 0

for _ in range(n):
    x = int(input())
    if x >= cur:
        while cur <= x:
            stk.append(cur)
            result.append('+')
            cur += 1
        stk.pop()
        result.append('-')
    else: # x <= cur
        if stk:
            tmp = stk.pop()
            result.append('-')
            while tmp > x:
                tmp = stk.pop()
                result.append('-')
        else:
            flag = 1
    

if flag == 1:
    print("NO")

if flag == 0:
    for p in result:
        print(p)