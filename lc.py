import sys
from collections import deque

input = sys.stdin.readline

M, N = map(int, input().split())

maps = []
for i in range(N) : 
    maps.append(list(map(int, input().split())))

tomato = []
for i in range(N) : 
    for j in range(M) : 
        if maps[i][j] == 1 : 
            tomato.append((i, j))


dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

def bfs(lst) : 
    queue = deque(lst)

    while queue : 
        y, x = queue.popleft()

        for i in range(4) : 
            nx = x + dx[i] 
            ny = y + dy[i]
            
            if 0 <= ny < N and 0 <= nx < M and maps[ny][nx] == 0 :
                maps[ny][nx] = maps[y][x] + 1
                queue.append((ny, nx))


bfs(tomato)

flag = True

for i in range(N) : 
    for j in range(M) :
        if maps[i][j] == 0 :
            flag = False

max_one = 0


for i in range(N) :
    for j in range(M) :
        if maps[i][j] > max_one :
            max_one = maps[i][j]


if flag == False :
    print(-1)
else : 
    print(max_one - 1)