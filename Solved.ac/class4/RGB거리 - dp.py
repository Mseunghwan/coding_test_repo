import sys

input = sys.stdin.readline

n = int(input())
maps = [0] * n
dp = [[0] * 3 for _ in range(n)]


for i in range(n) :  
    maps[i] = list(map(int, input().split()))

"""
생각해보면,
지금 무슨 값(dp[i])을 선택하냐에 따라 이전의 값을 골라주면 되므로
dp[i][0] = min(dp[i-1][1] + dp[i-1][2]) + maps[i][0]
"""
# 첫 행은 그대로
dp[0] = maps[0]

for i in range(1, n):
    dp[i][0] = min(dp[i-1][1], dp[i-1][2]) + maps[i][0]
    dp[i][1] = min(dp[i-1][0], dp[i-1][2]) + maps[i][1]
    dp[i][2] = min(dp[i-1][0], dp[i-1][1]) + maps[i][2]

print(min(dp[n-1]))
    