a = list(input())
lst = "abcdefghijklmnopqrstuvwxyz"

for i in lst:
    if i in a:
        print(a.index(i), end=" ")
    else:
        print(-1, end=" ")