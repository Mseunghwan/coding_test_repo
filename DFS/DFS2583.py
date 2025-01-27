import sys
sys.setrecursionlimit(10000)
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

dy = [0, -1, 0, 1]
dx = [1, 0, -1, 0]

def dfs(y, x, cnt):
    ground[y][x] = 1
    for k in range(4):
        ny = y + dy[k]
        nx = x + dx[k]
        if(0 <= ny < m and 0 <= nx < n and ground[ny][nx] == 0):
            cnt = dfs(ny, nx, cnt + 1)
    return cnt

res = []

for i in range(m):
    for j in range(n):
        if(ground[i][j] == 0):
            res.append(dfs(i, j, 1))

print(len(res))
print(*sorted(res))