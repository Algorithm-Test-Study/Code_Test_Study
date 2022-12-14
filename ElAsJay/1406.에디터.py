import sys

stk1 = list(sys.stdin.readline().strip())
stk2 = []

for _ in range(int(input())):
    mes = list(sys.stdin.readline().split())
    op = mes[0]

    if op == 'P':
        stk1.append(mes[1])

    elif op == 'L':
        if stk1:
            stk2.append(stk1.pop())
        else:
            continue

    elif op == 'D':
        if stk2:
            stk1.append(stk2.pop())
        else:
            continue

    elif op == 'B':
        if stk1:
            stk1.pop()
        else:
            continue
    else:
        break
    
stk1.extend(reversed(stk2))
print(''.join(stk1))