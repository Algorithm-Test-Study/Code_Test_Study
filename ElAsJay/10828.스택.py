import sys

t = int(input())
stk = []
for _ in range(t):
    command= sys.stdin.readline().split()
    op = command[0]
    if op == "push":
        stk.append(command[1])
    elif op == "pop":
        if stk:
            print(stk.pop())
        else:
            print(-1)
    elif op == "size":
        print(len(stk))
    elif op == "empty":
        if stk:
            print(0)
        else:
            print(1)
    elif op == "top":
        if stk:
            a = stk.pop()
            print(a)
            stk.append(a)
        else:
            print(-1)
    else:
        break