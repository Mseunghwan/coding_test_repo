import sys

input = sys.stdin.readline


t = int(input())

for i in range(t):
    n = int(input())

    dp = [[0] * n for _ in range(2)]
    lst = []

    lst.append(list(map(int, input().split())))
    lst.append(list(map(int, input().split())))

    if n == 1:
        print(max(dp[0][0], dp[1][0]))
        continue
    dp[0][0] = lst[0][0]
    dp[1][0] = lst[1][0]
    dp[0][1] = dp[1][0] + lst[0][1]
    dp[1][1] = dp[0][0] + lst[1][1]
    
    for j in range(2, n) : 
        dp[0][j] = max(dp[1][j-1], dp[1][j-2]) + lst[0][j]
        dp[1][j] = max(dp[0][j-1], dp[0][j-2]) + lst[1][j]
        
    print(max(dp[0][n-1], dp[1][n-1]))

    """
    정확한 점화식:

    dp[0][0] = lst[0][0]                  # 첫 번째 열, 위쪽 선택
    dp[1][0] = lst[1][0]                  # 첫 번째 열, 아래쪽 선택

    dp[0][1] = dp[1][0] + lst[0][1]       # 두 번째 열, 위쪽 선택 시 아래쪽 첫 번째 열에서 옴
    dp[1][1] = dp[0][0] + lst[1][1]       # 두 번째 열, 아래쪽 선택 시 위쪽 첫 번째 열에서 옴

    # 그 이후부터는 점화식 적용
    for j >= 2:
        dp[0][j] = max(dp[1][j-1], dp[1][j-2]) + lst[0][j]
        dp[1][j] = max(dp[0][j-1], dp[0][j-2]) + lst[1][j]
"""
