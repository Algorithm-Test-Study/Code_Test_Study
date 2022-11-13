import sys

result = []
cnt = 0
while 1:
    try:
        lst = input()
        if lst == -1: # EOF 처리 -1
            break
        else:
            lst_s = lst.split()
            for x in lst_s:
                if cnt != 0:
                    x = "".join(reversed(x)).lstrip("0")
                    result.append(int(x))
                cnt += 1
    except EOFError:
        break

res = sorted(result)
for i in res:
    print(i)

