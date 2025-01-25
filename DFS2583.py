import sys

input = sys.stdin.readline
m, n, k = map(int, input().split())

ground = [[0] * n for _ in range(m)]

lst = []
for i in range(k):
    x1, y1, x2, y2 = map(int, input().split())
    lst.append([x1, y1, x2, y2])
for i in range(len(lst)):
    for j in range(m - lst[i][3], m - lst[i][1]):
        for k in range(lst[i][0], lst[i][2]):
            ground[j][k] = 1


for i in range(m):
    for j in range(n):
        print(ground[i][j], end=" ")
    print()

def dfs():
    