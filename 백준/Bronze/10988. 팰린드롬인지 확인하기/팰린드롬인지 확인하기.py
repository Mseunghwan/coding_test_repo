a = str(input())
result = 0
lst = []
lst_reverse = []
if(len(a) % 2 == 0):
    for i in range(len(a) // 2):
        lst.append(a[i])
    for i in range((len(a) // 2), len(a)):
        lst_reverse.append(a[i])
    lst_reverse.reverse()
    if(lst == lst_reverse):
        result = 1
else:
    for i in range(len(a) // 2):
        lst.append(a[i])
    for i in range((len(a) // 2) + 1, len(a)):
        lst_reverse.append(a[i])
    lst_reverse.reverse()
    if(lst == lst_reverse):
        result = 1
print(result)