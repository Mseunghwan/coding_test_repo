"""
슬라이딩 윈도우 미활용 
--> 시간초과 에러발생


import sys

input = sys.stdin.readline
n, x = map(int, input().split())

visitor = list(map(int, input().split()))
result = []
for i in range(len(visitor)):
    count = 0
    for j in range(i, i + x):
        if(j < len(visitor)):
            count += visitor[j]
    result.append(count)
    
cnt = 0
if max(result) == 0:
    print("SAD")
else:
    print(max(result))
    for i in result:
        if i == max(result):
            cnt += 1
    print(cnt)
"""
# 슬라이딩 윈도우 활용
import sys

input = sys.stdin.readline
n, x = map(int, input().split())

visitor = list(map(int, input().split()))

val = sum(visitor[:x])
max_val = val
max_cnt = 1

for i in range(x, n):
    val += visitor[i]
    val -= visitor[i - x]
    if max_val < val:
        max_val = val
        max_cnt = 1
    elif max_val == val:
        max_cnt += 1

if max_val :
    print(max_val)
    print(max_cnt)
else:
    print("SAD")
