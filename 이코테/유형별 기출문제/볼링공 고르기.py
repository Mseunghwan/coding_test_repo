import sys
from itertools import permutations

input = sys.stdin.readline

n, m = map(int, input().split())

balls = list(map(int, input().split()))
balls.sort()
"""
cnt = 0
for i in range(n):
    for j in range(i, n):
        if balls[j] > balls[i]:
            cnt += 1

print(cnt)"
""
"""
"""
경우의 수로(아래)
현재 무개가 x인 공의 개수 * b가 선택하는 경우의 수 ---> 이를 다 +
"""
weight = [0] * (m + 1)
for i in range(1, m + 1):
    weight[i] = balls.count(i)

result = 0
for i in range(1, m + 1):
    result += weight[i] * sum(weight[i + 1:])
print(result)