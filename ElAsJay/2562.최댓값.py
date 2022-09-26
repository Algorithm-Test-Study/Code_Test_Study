s=[]
for i in range(9):
    # 사용자 입력 값을 배열에 append (총 9개의 값을 입력)
    s.append(int(input()))

# 배열의 원소들 중 최댓값 출력
print(max(s))
# 최댓값의 인덱스를 찾고 출력 (1부터 시작하므로 '+1')
print(s.index(max(s))+1)