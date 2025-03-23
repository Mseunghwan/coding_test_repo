"""
입력 : 
5 6
101010
111111
000001
111111
111111
"""
import sys
from collections import deque

input = sys.stdin.readline

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

def bfs(a, b):
    queue = deque([(a, b, 1)])

    while queue:
        y, x, cnt = queue.popleft()
        if y == (n-1) and x == (m-1):
            return cnt
            
        maps[y][x] = 0
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if 0 <= ny < n and 0 <= nx < m and maps[ny][nx] == 1:
                maps[ny][nx] = 0
                queue.append((ny, nx, cnt + 1))
    return -1

n, m = map(int, input().split())
maps = []
for i in range(n):
    maps.append(list(map(int, list(input().rstrip()))))

print(bfs(0, 0))