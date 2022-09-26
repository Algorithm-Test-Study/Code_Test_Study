nums = []
sum = 0

# 5개 숫자 입력, 입력한 숫자의 합 계산
for _ in range(5):
    a = int(input())
    nums.append(a)
    sum += a

# 입력한 숫자 배열 정렬
nums.sort()

print(round(sum/5))
print(nums[2])