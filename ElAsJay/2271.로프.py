import sys
input = sys.stdin.readline

# 0. input
n = int(input())

weight = []
for _ in range(n):
    weight.append(int(input()))

# 1. search
if n == 1:
    print(weight[0])

else:
    weight = sorted(weight)
    max_w = []
    for i in range(n):
        max_w.append(weight[i]*(n-i))
    print(max(max_w))