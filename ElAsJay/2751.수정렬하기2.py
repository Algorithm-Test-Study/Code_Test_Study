import sys
T = int(input())
num = []
for _ in range(T):
    num.append(int(sys.stdin.readline()))
for n in sorted(num):
    sys.stdout.write(str(n)+'\n')