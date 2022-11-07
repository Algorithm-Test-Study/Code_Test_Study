import sys

n = int(sys.stdin.readline())
eggs = []
for _ in range(n):
    eggs.append(list(map(int, sys.stdin.readline().split())))

broken_egg = 0

def break_check(eggs):
    count = 0
    for egg in eggs:
        if egg[0] <= 0:
            count += 1
    return count

def hit(idx1):
    global broken_egg

    if idx1 == n:
        broken_egg = max(broken_egg , break_check(eggs))
        return

    if eggs[idx1][0] <= 0: # 현재 손에 들고 있는 계란이 깨진 경우
        hit(idx1+1)
    else:
        all_broken = True
        for i in range(n):
            if i != idx1 and eggs[i][0] > 0:
                all_broken = False
                eggs[idx1][0] -= eggs[i][1]
                eggs[i][0] -= eggs[idx1][1]
                hit(idx1+1)
                eggs[idx1][0] += eggs[i][1]
                eggs[i][0] += eggs[idx1][1]
        
        if all_broken:
            hit(n)
#    for i in range(idx2, n):
#        check = break_check(eggs[idx1], eggs[i])
#        if check == 1:
#            broken_egg += 1
#            hit(idx1+1, i)
#        elif check == 2:
#            broken_egg += 1
#        elif check == 3:
#            broken_egg += 2
#            hit(idx1+1, i+1)


hit(0)
print(broken_egg)
