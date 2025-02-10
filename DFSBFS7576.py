import sys
from collections import deque

input = sys.stdin.readline



m, n = map(int, input().split())
box = []
for i in range(n):
    box.append(list(map(int, input().split())))

# bfs 필수인 Q 설정
# 4 방향이니 dx, dy 설정
q = deque()
dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

# Q에 토마토가 들어있는 위치 넣기
for i in range(n):
    for j in range(m):
        if(box[i][j] == 1):
            q.append((i, j))

def bfs():
    while q:
        y, x = q.popleft()

        # 4 방향 탐색
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if(0 <= ny < n and 0 <= nx < m and box[ny][nx] == 0):
                box[ny][nx] = box[y][x] + 1
                q.append((ny, nx))
bfs() # 돌려주기

max_day = 0
for i in box:
    for tomato in i:
        if tomato == 0:
            print(-1)
            exit()
        else:
            max_day = max(max_day, tomato)
print(max_day - 1)