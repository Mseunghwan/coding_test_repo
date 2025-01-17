n = int(input())
lst = list(map(int, input().split()))
line = []
num = 1
while lst:
    if lst[0] == num:
        lst.pop(0)
        num += 1
    else:
        line.append(lst.pop(0))

    while line:
        if line[-1] == num:
            line.pop()
            num+=1
        else:
            break
    
if not line:
    print('Nice')
else:
    print('Sad')