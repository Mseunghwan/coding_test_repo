import sys

input = sys.stdin.readline

n = int(input())
maps = []
dp = [[0] * i for i in range(1, n + 1)]

for i in range(n):
    maps.append(list(map(int, input().split())))

dp[0][0] = maps[0][0]

for i in range(1, n):
    for j in range(i + 1):
        if j == 0:
            dp[i][j] = dp[i-1][j] + maps[i][j]
        elif j == i:
            dp[i][j] = dp[i-1][j-1] + maps[i][j]
        else:
            dp[i][j] = max(dp[i-1][j-1], dp[i-1][j]) + maps[i][j]

print(max(dp[i]))
