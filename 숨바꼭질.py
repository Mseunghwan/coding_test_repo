import sys
from collections import deque

input = sys.stdin.readline

N, K = map(int, input().split())

maps = [0] * 100001
visited = [False] * 100001


def bfs(now, k) : 
    queue = deque([(now, 0)])

    while queue : 
        x, time = queue.popleft()
        if x == K : 
            return time
        
        if 0 <= x + 1 < len(maps) and visited[x + 1] == False: 
            visited[x + 1] = True
            queue.append((x + 1, time + 1))
        
        
        if 0 <= x - 1 < len(maps) and visited[x - 1] == False: 
            visited[x - 1] = True
            queue.append((x - 1, time + 1))
        
        
        if 0 <= x * 2 < len(maps) and visited[x * 2] == False: 
            visited[x * 2] = True
            queue.append((x * 2, time + 1))
        
        

visited[N] = True
rs = bfs(N, K)
print(rs)