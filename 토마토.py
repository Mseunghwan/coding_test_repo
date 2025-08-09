import sys
from collections import deque


input = sys.stdin.readline

M, N = map(int, input().split())

maps = []
for i in range(N) : 
    maps.append(list(map(int, input().split())))

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

tomato = []
# 토마토 위치 찾기
for i in range(N) :
    for j in range(M) : 
        if maps[i][j] == 1 : 
            tomato.append([i, j])


def bfs(lst) : 
    queue = deque(lst)

    while queue : 
        y, x = queue.popleft()

        for k in range(4) : 
            ny = y + dy[k]
            nx = x + dx[k]
            if 0 <= ny < N and 0 <= nx < M and maps[ny][nx] == 0 : 
            
                maps[ny][nx] = maps[y][x] + 1
                queue.append((ny, nx))



bfs(tomato)

flag = 0
for i in range(N) : 
    for j in range(M) : 
        if maps[i][j] == 0 : 
            flag = 1

max_one = 0
for i in range(len(maps)) : 
    if max(maps[i]) > max_one :
        max_one = max(maps[i])

if flag == 1 : 
    print(-1)
else : 
    print(max_one - 1)