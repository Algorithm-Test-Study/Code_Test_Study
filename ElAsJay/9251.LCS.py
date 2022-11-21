import sys
input = sys.stdin.readline

s1 = input().strip()
s2 = input().strip()

len1 = len(s1)
len2 = len(s2)

# s1의 각 문자에 대하여 s2 문자열에서 각 자리가 가질 수 있는 최대 길이
cache = [0 for _ in range(len2)]

for i in range(len1):
    cnt = 0
    for j in range(len2):
        if cnt < cache[j]:
            cnt = cache[j]
        elif s1[i] == s2[j]:
            cache[j] = cnt + 1
print(max(cache))