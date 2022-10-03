from collections import deque
import sys

n = int(sys.stdin.readline())
deq = deque()

for _ in range(n):
    command= sys.stdin.readline().split()
    op = command[0]
    
    if op == "push_front":
        deq.appendleft(command[1])
    elif op == "push_back":
        deq.append(command[1])
    
    elif op == "pop_front":
        if deq:
            print(deq.popleft())
        else:
            print(-1)
    elif op == "pop_back":
        if deq:
            print(deq.pop())
        else:
            print(-1)
    
    elif op == "size":
        print(len(deq))
    
    elif op == "empty":
        if deq:
            print(0)
        else:
            print(1)
    
    elif op == "front":
        if deq:
            print(deq[0])
        else:
            print(-1)
    
    elif op == "back":
        if deq:
            print(deq[-1])
        else:
            print(-1)
    
    else:
        break