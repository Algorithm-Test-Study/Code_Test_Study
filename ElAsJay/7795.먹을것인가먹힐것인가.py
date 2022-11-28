import sys
t = int(input())

for _ in range(t):
    a, b = map(int, sys.stdin.readline().split())
    a_weight = list(map(int, input().split()))
    b_weight = list(map(int, input().split()))
    
    a_weight.sort()
    b_weight.sort()

    cnt = 0
    result = 0
    for x in range(a):
        while True:
            if cnt == b or a_weight[x] <= b_weight[cnt]:
                result += cnt
                break
            else:
                cnt += 1
                
    print(result)