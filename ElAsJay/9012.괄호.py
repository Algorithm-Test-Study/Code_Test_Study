from sys import stdin

t = int(input())

for _ in range(t):
    ps = stdin.readline()[:-1]
    stk = []
    for p in ps:
        if not stk:
            stk.append(p)
            if p == ')':
                break
        else:
            if p == '(':
                stk.append(p)
            else:
                stk.pop()
    
    if stk:
        print("NO")
    else:
        print("YES")