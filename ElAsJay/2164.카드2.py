from collections import deque
n = int(input())

card = deque([i for i in range(1, n+1)])

while True:
    if len(card) > 1:
        card.popleft()
        card.append(card.popleft())
    else:
        result = card.pop()
        print(result)
        break