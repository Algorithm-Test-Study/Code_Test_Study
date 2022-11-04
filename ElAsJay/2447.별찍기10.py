n = int(input())

main_pattern = ["***", "* *", "***"]

def star(n):
    if n == 3:
        return main_pattern
    
    tmp_arr = star(n//3)
    stars = []

    for pattern in tmp_arr:
        stars.append(pattern * 3)
    
    for pattern in tmp_arr:
        stars.append(pattern + " "*(n//3) + pattern)

    for pattern in tmp_arr:
        stars.append(pattern * 3)
    
    return stars

print("\n".join(star(n)))

