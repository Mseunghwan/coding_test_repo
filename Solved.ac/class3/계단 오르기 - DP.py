import sys

input = sys.stdin.readline

n = int(input())

stairs = []
dp = [0] * (n + 1)
for i in range(n):
    stairs.append(int(input()))

# 마지막 계단 밟아야 하니.
# 1. 전 칸 밟고 마지막 칸 밟는 : (n - 1) + n
# 2. 전 전 칸 밟고 마지막 칸 밟는 : (n - 2) + n
# --> 하지만 전칸 밟으면 그 전칸은 밟으면 안되기에 : (n - 1) + (n - 3) + n 

# dp[i] = stairs[i] + dp[i - 2]
# dp[i] = stairs[i] + stair[i - 1] + dp[i - 3]


if n == 1:
    print(stairs[0])
elif n == 2:
    print(stairs[0] + stairs[1])
else : 
    dp[0] = stairs[0]
    dp[1] = max(stairs[1] + stairs[0], stairs[1])
    dp[2] = max(stairs[2] + stairs[0], stairs[1] + stairs[2])
    for i in range(3, n):
        dp[i] = max(stairs[i] + dp[i - 2], stairs[i] + stairs[i - 1] + dp[i - 3])
    print(dp[n - 1])

# https://www.acmicpc.net/problem/2579

# 점화식 세우는 연습 해야겠다