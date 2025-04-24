import sys

input = sys.stdin.readline

t = int(input())


for i in range(t):
    n = int(input())

    dp = [0] * 5
    dp[0] = 1
    dp[1] = 1
    dp[2] = 1
    dp[3] = 2
    dp[4] = 2
    
    if n <= 3 : 
        print(dp[n - 1])
    else :
        for j in range(5, n):
            dp.append(dp[j - 3] + dp[j - 2])
        print(dp[n - 1])
# https://www.acmicpc.net/problem/9461