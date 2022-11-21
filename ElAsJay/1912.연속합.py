import sys
input = sys.stdin.readline

# 0. input
n = int(input())
arr = list(map(int, input().split()))

# 1. find the largest sum
for i in range(1, n):
    arr[i] = max(arr[i-1]+arr[i], arr[i])

print(max(arr))