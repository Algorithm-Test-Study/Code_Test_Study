n, r, c = map(int, input().split())

def search(n, r, c):
    if n == 0:
        return 0
    return 2*(r%2)+(c%2) + 4*search(n-1, int(r/2), int(c/2))

print(search(n,r,c))