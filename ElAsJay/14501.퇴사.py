import sys
input = sys.stdin.readline

# 0. input
n = int(input())
rsv = [list(map(int, input().split())) for _ in range(n)] # reservation(time-price)
price = [0 for _ in range(n+1)]

# 1. dynamic programming (search)(revsered)
for i in range(n-1, -1, -1):
    if i + rsv[i][0] > n:
        price[i] = price[i+1]
    else:
        price[i] = max(rsv[i][1]+price[i+rsv[i][0]], price[i+1])

# 2. print
print(max(price))