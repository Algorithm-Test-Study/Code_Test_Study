from sys import stdin

n = int(input())
good = 0

for _ in range(n):
    words = stdin.readline()[:-1]
    stk = []
    for w in words:
        if not stk:
            stk.append(w)
        else:
            if stk[-1] == w:
                stk.pop()
            else:
                stk.append(w)
    if not stk:
        good += 1
    
print(good)