n = int(input())

img = [list(map(int, input())) for _ in range(n)]

def quad_tree(x, y, n):
    check = img[x][y]
    for i in range(x, x+n):
        for j in range(y, y+n):
            if img[i][j] != check:
                check = -1
                break
    
    if check == -1:
        print("(", end="")
        n = n//2
        quad_tree(x, y, n)
        quad_tree(x, y+n, n)
        quad_tree(x+n, y, n)
        quad_tree(x+n, y+n, n)
        print(")",end="")
        return

    elif check == 0:
        print(0, end="")
        return
    elif check == 1:
        print(1, end="")
        return

quad_tree(0,0,n)