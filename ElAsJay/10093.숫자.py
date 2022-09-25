a,b = map(int, input().split())

print(b-a-1)
for x in range(a+1,b):
    print(x, end=" ")