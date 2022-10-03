import sys

ps = sys.stdin.readline()[:-1]
stk = []
score = 0
tmp = 1

for i in range(len(ps)):
    p = ps[i]
    if p == '(':
        stk.append(p)
        tmp *= 2
    
    elif p == '[':
        stk.append(p)
        tmp *= 3
    
    elif p == ')':
        if not stk or stk[-1] == '[':
            score = 0 
            break
        elif ps[i-1] == '(':
            score += tmp
        stk.pop()
        tmp //= 2

    elif p == ']':
        if not stk or stk[-1] == '(':
            score = 0
            break
        elif ps[i-1] == '[':
            score += tmp
        stk.pop()
        tmp //= 3


if stk:
    score = 0

print(score)