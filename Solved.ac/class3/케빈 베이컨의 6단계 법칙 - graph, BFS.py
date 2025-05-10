import sys
from collections import deque

input = sys.stdin.readline

n, m = map(int, input().split())

graph = [[] for _ in range(n + 1)]

for i in range(m) :
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

result = [] # 결과 담기

def bfs(start) : 
    cnt = 0
    visited = [False] * ( n + 1 )
    queue = deque([])
    queue.append((0, start)) # count, 시작점

    visited[start] = True
    
    while queue : 
        count, cur = queue.popleft()


        for next in graph[cur]:
            if not visited[next] : 
                visited[next] = True
                queue.append((count + 1, next))
        
        cnt += count

    result.append((cnt, start))


for i in range(1, n+1):
    bfs(i)
    
result.sort()
print(result[0][1])
