T = int(input())

num=[]
for _ in range(T):
    num.append(int(input()))

for i in range(T):
    for j in range(i+1, T):
        if(num[i] > num[j]):
            t = num[i]
            num[i] = num[j]
            num[j] = t

for i in range(T):
    print(num[i])