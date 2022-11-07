from sys import stdin
from itertools import combinations

while True:
    nums = list(map(int, stdin.readline().split()))
    k = nums[0]
    if len(nums) == 1 and k == 0:
        break
    
    del nums[0]

    for comb in combinations(nums, 6):
        temp = list(map(str, comb))
        print(" ".join(temp))
    
    print("")
