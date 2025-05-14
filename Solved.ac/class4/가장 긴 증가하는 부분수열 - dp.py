import sys

input = sys.stdin.readline

n = int(input())

lst = list(map(int, input().split()))
dp = [1] * (n)

for i in range(n) :
    for j in range(i) :
        if lst[i] > lst[j] : 
            dp[i] = max(dp[i], dp[j] + 1)

print(max(dp))

"""
dp를 활용해 지금까지의 가장 긴 수열 수를 저장하는 dp를 갖고, 이전의 값보다 크면 +1을 해주는 방식으로 하면서 해결
"""