import sys
from collections import deque


t = int(sys.stdin.readline())
for _ in range(t):
    command = list(sys.stdin.readline().strip())
    n = int(sys.stdin.readline())
    n_list = deque(sys.stdin.readline()[1:-2].split(","))
    flag, rev = 0, 0
    num = deque(n_list)

    if n == 0:
        num = []

    for op in command:
        if op == 'R':
            rev += 1
        else: # op == 'D'
            if len(num) == 0:
                print("error")
                flag = 1
                break
            else:
                if rev % 2 == 0:
                    num.popleft()
                else:
                    num.pop()

    if flag == 0:
        if rev % 2 == 0:
            print("[" + ",".join(num) + "]")
        else:
            num.reverse()
            print("[" + ",".join(num) + "]")
