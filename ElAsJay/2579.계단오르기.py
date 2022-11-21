import sys
input = sys.stdin.readline

# 0. input
steps = int(input())
scores= []
dp = []

for _ in range(steps):
    scores.append(int(input()))

# 1. dp -> find the highest score

if steps <= 2:
    print(sum(scores))
else:
    dp.append(scores[0])
    dp.append(scores[0]+scores[1])
    dp.append(max(scores[0]+scores[2], scores[1]+scores[2]))

    for i in range(3, steps):
        dp.append(max(dp[i-3]+scores[i-1]+scores[i], dp[i-2]+scores[i]))

    print(dp[steps-1])