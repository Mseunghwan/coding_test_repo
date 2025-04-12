import sys
from collections import deque

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

def bfs(y, x):
    queue = deque([(y, x)])
    while queue:
        nowy, nowx = queue.popleft()
        for i in range(4):
            nx = dx[i] + nowx
            ny = dy[i] + nowy
            if 0 <= nx < M and 0 <= ny < N and maps[ny][nx] == 1 and visited[ny][nx] == False:
                visited[ny][nx] = True
                queue.append((ny, nx))
    return 0


input = sys.stdin.readline

T = int(input())

for i in range(T):
    cnt = 0
    M, N, K = map(int, input().split())
    maps = [[0] * M for _ in range(N)]

    for j in range(K):
        x, y = map(int, input().split())
        maps[y][x] = 1

    #
    visited = [[False] * M for _ in range(N)]
    cnt = 0
    for a in range(N):
        for b in range(M):
            if maps[a][b] == 1 and visited[a][b] == False:
                visited[a][b] = True
                bfs(a, b)
                cnt += 1

    print(cnt)






