from sys import stdin

t = int(stdin.readline())

co = [list(map(int, stdin.readline().split())) for _ in range(t)]

co.sort(key = lambda x: (x[0], x[1]))

for i in range(t):
    print(co[i][0], co[i][1])
