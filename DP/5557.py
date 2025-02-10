import sys

input = sys.stdin.readline

n = int(input())
dp = [[0] * 21 for _ in range(n)]
number = list(map(int, input().split()))

dp[0][number[0]] = 1
for i in range(1, n-1):
    for j in range(21):
        if dp[i-1][j]:
            if 0<= j + number[i] <= 20:
                dp[i][j+number[i]] += dp[i-1][j]
            if 0<= j-number[i]<=20:
                dp[i][j-number[i]] += dp[i-1][j]
print(dp[n-2][number[-1]])