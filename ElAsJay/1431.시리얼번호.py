from sys import stdin

t = int(stdin.readline())

serials = []

for _ in range(t):
    key = stdin.readline().strip()
    sum = 0
    for k in key:
        if k.isdigit():
            sum += int(k)
    serials.append([key, len(key), sum])

serials.sort(key = lambda x:(x[1], x[2], x[0]))

for i in range(t):
    print(serials[i][0])