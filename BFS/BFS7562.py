"""
"""

import sys
input = sys.stdin.readline
from collections import deque


dx = [1, 2, 2, 1, -1, -2, -2, -1]
dy = [2, 1, -1, -2, -2, -1, 1, 2]
def bfs(nowx, nowy, tox, toy):
    queue = deque()
    queue.append((nowx, nowy))
    while(queue):
        x, y = queue.popleft()
        if(x == tox and y == toy):
            return ground[x][y]
        for k in range(8):
            nx = x + dx[k]
            ny = y + dy[k]
            if(0<=nx<size and 0<=ny<size and ground[nx][ny] == 0):
                ground[nx][ny] = ground[x][y] + 1
                queue.append((nx, ny))

t = int(input())
for i in range(t):
    size = int(input())
    nowx, nowy = map(int, input().split())
    tox, toy = map(int, input().split())
    ground = [[0] * size for _ in range(size)]
    print(bfs(nowx, nowy, tox, toy))

