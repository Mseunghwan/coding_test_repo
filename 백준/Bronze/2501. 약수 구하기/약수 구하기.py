n, k = input().split()
n = int(n)
k = int(k)
lst = []
for i in range(1, n + 1):
    if((n % i) == 0):
        lst.append(i)
for i in range(1, k):
    if(len(lst) != 0):
        lst.remove(min(lst))

if(len(lst) == 0):
    print(0)
else:
    print(lst[0])
