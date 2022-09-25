import sys

len = int(sys.stdin.readline())
nums = list(map(int, sys.stdin.readline().split()))
s = int(sys.stdin.readline())

# 입력한 숫자들 오름차순 정렬
nums.sort()

pair = 0
start, end = 0, len-1
t_sum = 0

# start, end 를 이용해 비교 검색
while start < end:
    t_sum = nums[start] + nums[end]
    if t_sum == s:
        pair += 1
    elif t_sum < s:
        start += 1
        continue
    end -= 1

print(pair)