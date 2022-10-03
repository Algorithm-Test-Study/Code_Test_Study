import sys
from collections import deque

t = int(input())
queue = deque()

for _ in range(t):
    command= sys.stdin.readline().split()
    op = command[0]
    if op == "push":
        queue.append(int(command[1]))
    elif op == "pop":
        if queue:
            print(queue.popleft())
        else:
            print(-1)
    elif op == "size":
        print(len(queue))
    elif op == "empty":
        if queue:
            print(0)
        else:
            print(1)
    elif op == "front":
        if queue:
            print(queue[0])
        else:
            print(-1)
    elif op == "back":
        if queue:
            print(queue[-1])
        else:
            print(-1)
    else:
        break