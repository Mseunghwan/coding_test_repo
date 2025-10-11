import sys
import heapq

# 인접 행렬로 푸는 PRIM 

input = sys.stdin.readline

N = int(input())

graph = []

visited = [False] * N
heap = [(0, 0)]
total = 0
for i in range(N) : 
    graph.append(list(map(int, input().split())))

while heap : 
    w, v = heapq.heappop(heap)

    if visited[v] : 
        continue
    
    visited[v] = True
    total += w

    for next_v in range(N) : 
        next_w = graph[v][next_v]

        # 자기 자신 아니고, 간선 존재하고, 방문 안했으면
        if not visited[next_v] and next_w != 0 : 
            heapq.heappush(heap, (next_w, next_v))



print(total)
    
