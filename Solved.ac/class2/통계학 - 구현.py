import sys
from collections import Counter
input = sys.stdin.readline

n = int(input())
lst = []
for i in range(n):
    lst.append(int(input()))

lst.sort()
# 산술평균 
print(round(sum(lst) / n))
# 중앙값
print(lst[n//2])
# 최빈값
cnt = Counter(lst)
max_cnt = max(cnt.values())
most_one = []
for i, j in cnt.items():
    if j == max_cnt : 
        most_one.append(i)
most_one.sort()
if len(most_one) > 1 : 
    print(most_one[1])
else : 
    print(most_one[0])

# 범위
print(max(lst) - min(lst))
