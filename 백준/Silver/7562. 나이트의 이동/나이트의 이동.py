"""
음 그야말로, 정석같은 문젠데 왜 다 잘 세워두고 def bfs를 잘 못만드는지 좀더 분발하란말야!
시작점을 1로, 안간 곳이 0 이니, 이전에 간 곳을 씌워주는데 시작 후 직후 가는곳이 1 + 1이니 2,
그 다음이 2 + 1 이런식으로 몇 번째에 갔는지 return하는 방식으로 해를 찾아간다
"""

import sys
input = sys.stdin.readline
from collections import deque


dx = [1, 2, 2, 1, -1, -2, -2, -1]
dy = [2, 1, -1, -2, -2, -1, 1, 2]

def bfs():
    queue = deque()
    queue.append((nowx, nowy))
    while(queue):
        x, y = queue.popleft()
        if(x == tox and y == toy):
            return ground[x][y] - 1
        for k in range(8):
            nx = x + dx[k]
            ny = y + dy[k]
            if 0<=nx<size and 0<=ny<size and ground[nx][ny] == 0:
                ground[nx][ny] = ground[x][y] + 1
                queue.append((nx, ny))

t = int(input())
for i in range(t):
    size = int(input())
    nowx, nowy = map(int, input().split())
    tox, toy = map(int, input().split())
    ground = [[0] * size for _ in range(size)]
    ground[nowx][nowy] = 1
    print(bfs())

