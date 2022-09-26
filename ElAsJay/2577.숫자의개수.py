a = int(input())
b = int(input())
c = int(input())

# a*b*c의 값을 string으로 변환 후, list로 쪼갬 ex. 1234 -> 1, 2, 3, 4
m = list(str(a*b*c))

# 각 자연수가 몇 개씩 포함되어 있는지 계산
for i in range(10):
    print(m.count(str(i)))