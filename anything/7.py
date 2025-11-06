"""
import sys
from itertools import product

input = sys.stdin.readline

N, M = map(int, input().split())
nums = []
for i in range(N + 1):
    nums.append(i)
lst = list(product(nums, repeat = M))
cnt = 0
for i in lst:
    if sum(i) == N:
        cnt += 1
print(cnt)

"""
# 메모리 초과 나오니 backtracking 써야 한다

"""
import sys

input = sys.stdin.readline

N, M = map(int, input().split())
cnt = 0
def backtrack(depth, total):
    global cnt
    if depth == M:
        if total == N:
            cnt += 1
        return

    for i in range(N + 1):
        if (total + i) <= N:
            backtrack(depth + 1, total + i)
        
backtrack(0, 0)
print(cnt)

"""

# 시간 초과 나오니 DP로 해결해야 함

import sys

input = sys.stdin.readline

N, M = map(int, input().split())

