import sys
input = sys.stdin.readline

s = input()
s_len = len(s)
s = s[0:s_len-1]

suffix = []
for i in range(s_len -1):
    suffix.append(s[i:s_len])

suffix.sort()

for i in range(len(suffix)):
    print(suffix[i])