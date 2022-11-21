import sys
input = sys.stdin.readline

# 0. input
n = int(input())
meeting = []
for _ in range(n):
    meeting.append(list(map(int, input().split())))

# 1. sort
meeting.sort(key = lambda x : (x[1], x[0]))

# 2. search
cnt = 1
start_time = meeting[0][0]
end_time = meeting[0][1]

for i in range(1, n):
    if meeting[i][0] >= end_time:
        cnt += 1
        end_time = meeting[i][1]
print(cnt)