import sys

input = sys.stdin.readline


t = int(input())

for i in range(t):
    n = int(input())

    dp = [[0] * n for _ in range(2)]
    lst = []

    lst.append(list(map(int, input().split())))
    lst.append(list(map(int, input().split())))

    dp[0][0] = lst[0][0]
    dp[1][0] = lst[1][0]
    dp[0][1] = dp[1][0] + lst[0][1]
    dp[1][1] = dp[0][0] + lst[1][1]
    
    for j in range(2, n) : 
        dp[0][j] = max(dp[1][j-2], dp[1][j-1]) + lst[0][j]
        dp[1][j] = max(dp[0][j-2], dp[0][j-1]) + lst[1][j]

    print(max(dp[0][n-1], dp[1][n-1]))
    

    """
    자, 점화식을 세워보면
    dp[0][0] = lst[0][0]
    dp[1][0] = lst[0][0]
    dp[0][1] = max((dp[1][0] + lst[0][1]), dp[0][0])    
    dp[1][1] = max((dp[0][0] + lst[1][1]), dp[1][0])

    dp[0][i] = max(dp[0][i-2], dp[1][i-1]) + lst[0][i]
    dp[1][i] = max(dp[1][i-2], dp[0][i-1]) + lst[1][i]
    """
