import sys
from collections import deque

input = sys.stdin.readline

N, M, K, X = map(int, input().split())

graph = [[] for _ in range(N + 1)]

for i in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    
# 거리 저장 배열
distance = [-1] * (N + 1)
distance[X] = 0

def bfs(dist, start):
    queue = deque([start])
    while queue:
        now = queue.popleft()
        for next_node in graph[now]:
            if distance[next_node] == -1: # 아직 방문 아닐 시
                distance[next_node] = distance[now] + 1 # 현재 거리 + 1로 저장
                queue.append(next_node)



bfs(K, X)
if K not in distance :
    print(-1)
else:
    for i in range(len(distance)):
        if distance[i] == K:
            print(i)
        
