"""
점화식 dp[i] = dp[i-j] + p[j]
인데 들어갈때 가장 낮은 값 들어가도록

솔직히 잘 모르겠슴;;
"""

import sys
input = sys.stdin.readline

n = int(input())

price = list(map(int, input().split()))
price.insert(0, 0)

dp = [False] * (n+1)
for i in range(1, n + 1):
    for j in range(1, i+1):
        if(dp[i] == False):
            dp[i] = dp[i-j] + price[j]
        else:
            dp[i] = min(dp[i], dp[i-j] + price[j])
    
print(dp[n])