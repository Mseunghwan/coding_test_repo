import sys

input = sys.stdin.readline

n = int(input())

road = list(map(int, input().split()))
oil = list(map(int, input().split()))


total = road[0] * oil[0]
minimum = oil[0]

for now in range(1, n - 1):
    if minimum > oil[now]:
        minimum = oil[now]
    total += (minimum * road[now])

print(total)

