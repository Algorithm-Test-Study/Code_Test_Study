n = int(input())

result =[]
cnt = 0
def hanoi(n, src, dst, mid):
    global cnt
    if n == 1:
        result.append([src, dst])
        cnt += 1
        return
    hanoi(n-1, src, mid, dst)
    result.append([src, dst])
    cnt += 1
    hanoi(n-1, mid, dst, src)

hanoi(n, 1, 3, 2)
print(cnt)
for x in result:
    print(x[0], x[1])