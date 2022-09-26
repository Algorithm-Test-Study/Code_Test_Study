a,b = map(int, input().split())
d = abs(a-b)

if d<=1:
    print(0)
else:
    print(d-1)

for x in range(min(a,b)+1, max(a,b)):
    print(x, end=" ")