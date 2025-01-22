import sys
from collections import deque

input = sys.stdin.readline

m, n = map(int, input().split())

ground = []


for i in range(n):
    ground.append(list(map(int, input().split())))
for i in range(n):
    for j in range(m):
        if(ground[i][j] == 1):
            x, y = i, j
        

def bfs():
    queue = deque()
    queue.append((x, y))
    while(queue):
        

print(bfs())