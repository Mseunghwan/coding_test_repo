import sys

sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline

n = int(input())

lst = []
for i in range(n) :
    lst.append(list(input().strip()))
visited = [[False] * n for _ in range(n)]

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

def dfs(y, x, color) :
    visited[y][x] = True
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if 0 <= nx < n and 0 <= ny < n : 
            if visited[ny][nx] == False and lst[ny][nx] == color :
                 visited[ny][nx] = True
                 dfs(ny, nx, color)


cnt_normal = 0
cnt_non_normal = 0

# 보통 사람의 시야
for i in range(n) :
    for j in range(n) : 
        if visited[i][j] == False:
            dfs(i, j, lst[i][j])
            cnt_normal += 1

# 적록 색약 시야 - lst를 R, G 같게 한 후 돌림
for i in range(n):
    for j in range(n):
        if lst[i][j] == 'R' :
            lst[i][j] = 'G'


visited = [[False] * n for _ in range(n)]

for i in range(n) :
    for j in range(n) : 
        if visited[i][j] == False:
            dfs(i, j, lst[i][j])
            cnt_non_normal += 1


print(cnt_normal, cnt_non_normal)
