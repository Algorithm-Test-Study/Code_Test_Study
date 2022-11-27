import sys
input = sys.stdin.readline

n = int(input())
nums = [int(input()) for _ in range(n)]
nums = nums.sort(reverse=True)

for x in nums:
    print(x)