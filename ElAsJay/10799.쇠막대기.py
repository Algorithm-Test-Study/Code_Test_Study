ps = list(input())

stk = []

flag = 0
result = 0

for p in ps:
    if p == '(':
        stk.append(p)
        flag = 1
    else:
        if flag == 1:
            stk.pop()
            result += len(stk)
            flag = 0
        else:
            stk.pop()
            result += 1


print(result)