import sys

input = sys.stdin.readline
sys.setrecursionlimit(10**6)

N = int(input())

maps = []
visited = [[False] * N for _ in range(N)]
for i in range(N) : 
    maps.append(list(input().rstrip()))

dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

def dfs(y, x, color) : 
    for i in range(4) : 
        ny = y + dy[i]
        nx = x + dx[i]
        
        if 0 <= ny < N and 0 <= nx < N and visited[ny][nx] == False :
            if color == maps[ny][nx] :
                visited[ny][nx] = True
                dfs(ny, nx, color)

# 적록색약 X
normal_cnt = 0
for i in range(N) : 
    for j in range(N) : 
        if visited[i][j] == False : 
            dfs(i, j, maps[i][j])
            normal_cnt += 1


# 적록색약 버전 만들기
for i in range(N) : 
    for j in range(N) : 
        if maps[i][j] == 'G' : 
            maps[i][j] = 'R'

visited = [[False] * N for _ in range(N)]

# 적록색약
handi_cnt = 0
for i in range(N) : 
    for j in range(N) : 
        if visited[i][j] == False : 
            dfs(i, j, maps[i][j])
            handi_cnt += 1

print(normal_cnt, handi_cnt)