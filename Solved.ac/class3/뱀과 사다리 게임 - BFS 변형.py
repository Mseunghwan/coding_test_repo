import sys
from collections import deque

input = sys.stdin.readline

n, m = map(int, input().split())

maps = [0] * 101
visited = [False] * 101

# 사다리 정보
ladder = {}
for i in range(n):
    x, y = map(int, input().split())
    ladder[x] = y

# 뱀 정보
snake = {}
for i in range(m):
    u, v = map(int, input().split())
    snake[u] = v

def bfs(start) :
    queue = deque([])
    queue.append(start)
    visited[start] = True

    while queue:
        now = queue.popleft()
        for i in range(1, 7): # 주사위 1 ~ 6
            next = now + i
        
            if 0 <= next <= 100 and visited[next] == False:
                if next in ladder : 
                    next = ladder[next]
                
                if next in snake : 
                    next = snake[next]
                
                if not visited[next] : 
                    visited[next] = True
                    queue.append(next)
                    maps[next] = maps[now] + 1 # 횟수
bfs(1)
print(maps[100])
