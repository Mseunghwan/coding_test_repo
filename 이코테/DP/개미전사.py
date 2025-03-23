import sys

# dp 아이디어?
# 현재 위치 i라면, i - 1 번째 칸을 털면 현재 칸을 못털고
# i - 2번째 칸을 털면 현재 칸을 털고 값을 가져 갈 수 있다
# 그렇기에 i - 1 과 i - 2 + 현재 칸에 들어있는 값 중 큰 부분을 취하여
# 최대로 얻을 수 있는 부분을 구해가면 된다

# 1 3 1 5 20 5
# 3 20 이런식으로 털면 23
# 1 1 20 털면 22
# 3 5 5 털면 13

input = sys.stdin.readline

n = int(input())
lst = list(map(int, input().split()))
# dp 테이블 초기화
d = [0] * (n + 1)

d[0] = lst[0]
d[1] = max(lst[1], lst[0])
for i in range(2, n):
    d[i] = max(d[i - 1], d[i - 2] + lst[i])

print(d[n - 1])
