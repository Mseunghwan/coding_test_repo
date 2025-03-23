import sys
# dp 테이블 초기화
# x의 최댓값인 30000까지
dp = [0] * 30001 

def goto_1(x):
    for i in range(2, x + 1):
        # x에서 1을 뺀다
        dp[i] = dp[i-1] + 1
        # x가 2로 나누어지면, 2로 나눈다
        if i % 2 == 0 :
            dp[i] = min(dp[i], dp[i//2] + 1)

        # x가 3로 나누어지면, 3로 나눈다
        if i % 3 == 0 :
            dp[i] = min(dp[i], dp[i//3] + 1)

        # x가 5로 나누어지면, 5로 나눈다
        if i % 5 == 0 :
            dp[i] = min(dp[i], dp[i//5] + 1)
    return dp[x]

input = sys.stdin.readline

i = int(input())

print(goto_1(i))