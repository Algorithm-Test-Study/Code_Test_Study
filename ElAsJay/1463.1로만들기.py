import sys

n = int(sys.stdin.readline())
d = [0] * (n+1) # a1부터 시작하는 것으로 생각

# a1 = 0    a2 = 1      a3 = 1      a4 = 2 ...

for num in range(2, n+1):
    d[num] = d[num - 1] + 1

    if num % 3 == 0:
        d[num] = min(d[int(num/3)] + 1, d[num])
    if num % 2 == 0:
        d[num] = min(d[int(num/2)] + 1, d[num])

print(d[n])