from sys import stdin

while True:
    line = stdin.readline()[:-1]
    if line == ".":
        break
    stk = []
    for c in line:
        if c == '(' or c == '[':
            stk.append(c)
        elif c == ')':
            if stk and stk[-1] == '(':
                stk.pop()
            else:
                stk.append(c)
                break
        elif c == ']':
            if stk and stk[-1] == '[':
                stk.pop()
            else:
                stk.append(c)
                break
    if stk:
        print("no")
    else:
        print("yes")