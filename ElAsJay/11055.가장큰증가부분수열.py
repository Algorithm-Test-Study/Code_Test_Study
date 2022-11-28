import sys
input = sys.stdin.readline

# 0. input
arr_size = int(input())
arr = list(map(int, input().split()))
sum_arr = arr[:]
# 1. dynamic programming
for i in range(arr_size):
    for j in range(i):
        if arr[i] > arr[j]:
            sum_arr[i] = max(sum_arr[i], sum_arr[j]+arr[i])

# 2. print
print(max(sum_arr))