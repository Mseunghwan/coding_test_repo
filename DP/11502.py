"""
i개의 카드를 구매하는 최대 가격 dp[i]
점화식 : dp[i] = price[j] + dp[i-j]
"""
import sys

input = sys.stdin.readline

n = int(input())

price = list(map(int, input().split()))
price.insert(0, 0)

dp = [0] * (n+1)
for i in range(1, n+1):
    for j in range(1, i+1):
        dp[i] = max(dp[i], dp[i-j] + price[j])

print(dp[n])

