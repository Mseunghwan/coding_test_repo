"""
"""

import sys
input = sys.stdin.readline
from collections import deque


dx = [1, 2, 2, 1, -1, -2, -2, -1]
dy = [2, 1, -1, -2, -2, -1, 1, 2]
def bfs(nowx, nowy, tox, toy):
    queue = deque([(nowx, nowy)])
    cnt = 0
    while(queue):
        x, y = queue.popleft()
        for k in range(8):
            x = x + dx[k]
            y = y + dy[k]
            if(x == tox and y == toy):
                return cnt
            cnt += 1
            queue.append((x, y))

t = int(input())
for i in range(t):
    size = int(input())
    nowx, nowy = map(int, input().split())
    tox, toy = map(int, input().split())
    print(bfs(nowx, nowy, tox, toy))

