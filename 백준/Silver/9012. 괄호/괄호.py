import sys
n = int(sys.stdin.readline())
lst = ["(", ")", "[", "]"]
for i in range(n):
    a = sys.stdin.readline()
    check_a = 0
    check_b = 0
    
    for chr in a:
        if(chr == lst[0]):
            check_a += 1
        elif(chr == lst[1]):
            check_a -= 1
        elif(chr == lst[2]):
            check_b += 1
        elif(chr == lst[3]):
            check_b -= 1
        if(check_a < 0 or check_b < 0):
            break
    
    
    if((check_a == 0) & (check_b == 0)):
        print("YES")
    else:
        print("NO")