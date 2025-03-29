"""
아이디어?
주어진 화폐로 정해진 금액을 만드는 최소한의 화폐 수를 구해야 한다
--> 
i = 현재 인덱스
D[i] = 금액 i를 만들 수 있는 최소한의 화폐 개수
k = 각 화폐의 단위
D[i-k]를 만드는 방법이 존재하는 경우 D[i] = min(D[i], D[i-k] + 1)
--> 빠진 값 
D[i-k]를 만드는 방법이 존재하지 않는 경우 D[i] = INF
"""
# 최대 n 값이 10000이기에
INF = 10001

import sys

input = sys.stdin.readline

n, m = map(int, input().split())
coin = []
d = [INF] * (m + 1)

d[0] = 0
for i in range(n):
    coin.append(int(input()))

for i in range(n):
    for j in range(coin[i],m + 1):
        if d[j - coin[i]] != 10001: # i-k원을 만드는 방법이 존재하는 경우
            d[j] = min(d[j], d[j - coin[i]] + 1)

if d[m] == 10001:
    print(-1)
else:
    print(d[m])
    
