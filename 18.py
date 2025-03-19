import sys
from collections import deque


def bfs(y, x):
    visited[y][x] = True
    queue = deque([(y, x, 1)])

    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]
    while queue:
        ey, ex, cnt = queue.popleft()

        if ex == (M - 1) and ey == (N - 1):
            return cnt
        
        for i in range(4):
            nx = ex + dx[i]
            ny = ey + dy[i]
            if 0 <= nx < M and 0 <= ny < N:
                if visited[ny][nx] == False and maps[ny][nx] == 1:
                    visited[ny][nx] = True
                    queue.append((ny, nx, cnt + 1))
                    
                

input = sys.stdin.readline

N, M = map(int, input().split())

maps = []
# 공백없는 문자열 받을 시 rstrip으로 해주고 list로 감싸주면 돼
for i in range(N):
    maps.append(list(map(int, list(input().rstrip()))))

visited = [[False] * M for _ in range(N)]

print(bfs(0, 0))