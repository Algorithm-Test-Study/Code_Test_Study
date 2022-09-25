nums = []
sum = 0
for _ in range(5):
    a = int(input())
    nums.append(a)
    sum += a
nums.sort()
print(round(sum/5))
print(nums[2])