import sys
t = int(input())

judge = [list(sys.stdin.readline().split()) for _ in range(t)]

# lambda 사용
judge.sort(key = lambda x: int(x[0]))

for i in range(t):
    print(judge[i][0], judge[i][1])
    #print(f"{judge[i][0]} {judge[i][1]}", end="\n")