import sys

input = sys.stdin.readline

N = int(input())

# 점화식
# count(N) = min(count(N//3), count(N//2), count(N-1)) + 1

dp = [0] * 1000001

for i in range(2, N + 1) : 
    # 1뺀 경우
    dp[i] = dp[i - 1] + 1

    # 나누어 떨어지는 경우
    if i % 2 == 0 :
        dp[i] = min(dp[i], dp[i//2] + 1)

    if i % 3 == 0 : 
        dp[i] = min(dp[i], dp[i//3] + 1)

res = [N]
now = N
temp = dp[N] - 1
# path 구하기
for i in range(N, 0, -1) : 
    if dp[i] == temp and (i + 1 == now or i * 2 == now or i * 3 == now) : 
        now = i
        res.append(now)
        temp -= 1
print(dp[N])
print(*res)