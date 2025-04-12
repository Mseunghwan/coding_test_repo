import sys
from collections import deque

input = sys.stdin.readline


N, M = map(int, input().split())

real_maps = []
for i in range(N):
    real_maps.append(list(map(int, input().split())))


def copy_map(maps):
    return [row[:] for row in maps]

# 이동 좌표
dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

# 바이러스 전파
def bfs():
    maps = copy_map(real_maps)
    queue = deque()

    for i in range(N):
        for j in range(M):
            if maps[i][j] == 2:
                queue.append((i, j))


    while queue:
        y, x = queue.popleft()
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            if 0 <= ny < N and 0 <= nx < M and  maps[ny][nx] == 0:
                maps[ny][nx] = 2
                queue.append((ny, nx))

    global answer
    cnt = 0

    for i in range(N):
        cnt += maps[i].count(0)
    
    answer = max(answer, cnt)

# 벽 3개 세우기 - 백트래킹 활용
def makeWall(cnt):
    # 벽 3개가 세워지면 바이러스를 퍼뜨린다
    if cnt == 3:
        bfs()
        return
    
    for i in range(N):
        for j in range(M):
            if real_maps[i][j] == 0: # 벽 세우기 가능한 0
                real_maps[i][j] = 1 # 벽을 세우고
                makeWall(cnt + 1) # 두 번째 벽 세우러
                real_maps[i][j] = 0 # 벽 허무는 과정

answer = 0
makeWall(0, 0)
print(answer)

# 시간초과난다
