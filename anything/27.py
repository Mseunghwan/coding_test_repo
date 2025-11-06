import sys
from collections import deque

input = sys.stdin.readline


n, m, v = map(int, input().split())
visited = [False] * (n + 1)
# 인접 리스트로 풀기
graph = [[] for _ in range(n + 1)]

for i in range(m):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)

for i in range(n + 1):
    graph[i].sort()

def dfs(graph, start, visited):
    visited[start] = True
    print(start, end = " ")
    for i in graph[start]:
        if not visited[i]:
            dfs(graph, i, visited)


dfs(graph, v, visited)

visited = [False] * (n + 1)
print()

def bfs(graph, start, visited):
    queue = deque([start])
    visited[start] = True
    while(queue):
        now = queue.popleft()
        print(now, end = " ")
        for i in graph[now]:
            if not visited[i]:
                visited[i] = True
                queue.append(i)


bfs(graph, v, visited)
