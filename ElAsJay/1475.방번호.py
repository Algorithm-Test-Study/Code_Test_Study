import math
num = map(int, input())
c = [0 for _ in range(9)]

for n in num:
    if n==9:
        c[6] += 1
    else:
        c[n] += 1

c[6] = math.ceil(c[6]/2)
print(max(c))