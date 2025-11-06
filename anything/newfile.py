# 버블정렬
lst = [6, 4, 2, 5, 6 ,2, 1]

for i in range(len(lst) -1 , 0, -1) :
    for j in range(i) : 
        if lst[j] > lst[j + 1] : 
            lst[j], lst[j + 1] = lst[j + 1], lst[j]

print(lst)

lst = [6, 4, 2, 5, 6 ,2, 1]

# 선택정렬
for i in range(len(lst) - 1) : 
    min_idx = i
    for j in range(i + 1, len(lst)) : 
        if lst[min_idx] > lst[j] : 
            min_idx = j
    lst[i], lst[min_idx] = lst[min_idx], lst[i]

print(lst)

# 비트연산으로 부분집합 생성
for i in range(len(lst) << 1) : 
    for j in range(len(lst)) : 
        if i & (1 << j) : 
            print(lst[j], end = " ")
    print()