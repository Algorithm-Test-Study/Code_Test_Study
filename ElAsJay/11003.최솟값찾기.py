from collections import deque

n, l = map(int, input().split())
num = deque(map(int, input().split()))
window = deque()
result = []

for idx, val in enumerate(num):
    # window: [idx][val] -> (0, v0) 
    while window:
        if window[-1][1] > val:
            window.pop()
        else:
            break
    while window and window[0][0] < idx-l+1:
        # 현재 범위에 포함되지 않은 인덱스의 값은 없앰
        window.popleft()
    window.append((idx, val))
    result.append(window[0][1])
    
for i in range(n):
    print(result[i], end=" ")