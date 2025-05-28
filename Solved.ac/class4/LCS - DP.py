import sys

input = sys.stdin.readline

l1 = list(input().strip())
l2 = list(input().strip())

n = len(l1)
m = len(l2)

dp = [[0] * (m + 1) for _ in range(n + 1)]

for i in range(1, n + 1):
    for j in range(1, m + 1) :
        if l1[i - 1] == l2[j - 1] : 
            dp[i][j] = dp[i - 1][j - 1] + 1
        else :
            dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])

print(dp[n][m])
            

    
"""
DP 점화식 만듦
만약에 l1[i] == l2[i] : 
dp[i][j] = dp[i - 1][j - 1] + 1
만약에 l1[i] != l2[i] : 
dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
"""