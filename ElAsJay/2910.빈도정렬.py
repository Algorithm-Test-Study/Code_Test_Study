from sys import stdin
n, c = map(int, stdin.readline().split())
nums = list(map(int, stdin.readline().split()))

freq = {}

for n in nums:
    if n in freq:
        freq[n][0] += 1
    else:
        freq[n] = [1, nums.index(n)]
#print(freq)
result = sorted(freq.items(), key = lambda x:(-x[1][0], x[1][1]))
#print(result)

for r in result:
    for i in range(r[1][0]):
        print(r[0], end=" ")