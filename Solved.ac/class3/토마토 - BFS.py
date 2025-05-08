import sys
from collections import deque
input = sys.stdin.readline

m, n, h = map(int, input().split())

lst = []
for i in range(h) :
    area = []
    for j in range(n) :
        area.append(list(map(int, input().split())))
    lst.append(area)

visited = [[[False] * m for _ in range(n)] for _ in range(h)]

where = []

queue = deque()
# 1은 익은 토마토, 0은 익지 않은 토마토, -1은 토마토 없는 칸
# 익은 토마토 위치
for i in range(h) : 
    for j in range(n) :
        for k in range(m) :
            if lst[i][j][k] == 1 : 
                queue.append((i, j, k))

dx = [0, 1, 0, -1, 0, 0]
dy = [1, 0, -1, 0, 0, 0]
dz = [0, 0, 0, 0, -1, 1]

def bfs() :
    while queue : 
        z, y, x = queue.popleft()
        for i in range(6):
            nx, ny, nz = dx[i] + x, dy[i] + y, dz[i] + z
            if 0 <= nx < m and 0 <= ny < n and 0 <= nz < h : 
                if lst[nz][ny][nx] == 0 :
                    lst[nz][ny][nx] += lst[z][y][x] + 1
                    queue.append((nz, ny, nx))


bfs()

# 완수 했는지 확인
flag = False
result = 0
for i in range(h) : 
    for j in range(n) : 
        for k in range(m) : 
            if lst[i][j][k] == 0 :
                flag = True
            result = max(result, lst[i][j][k])

if flag : 
    print(-1)
else:
    print(result - 1)

# https://www.acmicpc.net/problem/7569
# 앞 뒤까지 고려하는 BFS