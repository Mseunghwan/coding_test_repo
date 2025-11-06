import sys

input = sys.stdin.readline

dp = [1] * 10001

for i in range(2, 10001):
    dp[i] += dp[i - 2]
for i in range(3, 10001):
    dp[i] += dp[i - 3]

n = int(input())
for i in range(n):
    now = int(input())
    print(dp[now])

"""
점화식 이해 더 필요
"""