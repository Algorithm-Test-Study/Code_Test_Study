n, k = map(int, input().split())
yos = [i+1 for i in range(n)]
result = []
tmp = 0

for _ in range(n):
    tmp = tmp + (k-1)
    if tmp >= len(yos):
        tmp = tmp % len(yos)    
    result.append(yos[tmp])
    yos.remove(yos[tmp])

print("<", end="")
for i in range(n):
    if i < n-1:
        print(result[i], end=", ")
    else:
        print(result[i], end=">")