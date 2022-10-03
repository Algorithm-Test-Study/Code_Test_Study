import sys

for _ in range(int(input())):
    key = list(sys.stdin.readline().strip())
    stk1 = []
    stk2 = []
    for k in key:
        if k == '<':
            if stk1:
                stk2.append(stk1.pop())
            else:
                continue
        elif k == '>':
            if stk2:
                stk1.append(stk2.pop())
            else:
                continue
        elif k == '-':
            if stk1:
                stk1.pop()
            else:
                continue
        else:
            stk1.append(k)
    stk1.extend(reversed(stk2))
    print(''.join(stk1))