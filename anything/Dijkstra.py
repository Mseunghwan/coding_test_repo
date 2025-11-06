import sys
import heapq

input = sys.stdin.readline

V, E = map(int, input().split())
start_node = int(input())

graph = [[] for _ in range(V + 1)]
dist = [float('inf')] * (V + 1)

for i in range(E) : 
    st, en, w = map(int, input().split())
    graph[st].append((w, en))

# 시작
dist[start_node] = 0
heap = [(0, start_node)]
# dijkstra 
while heap : 
    w, v = heapq.heappop(heap)
    
    if dist[v] != w : 
        continue
    
    for next_w, next_v in graph[v] : 
        if dist[next_v] > dist[v] + next_w : 
           dist[next_v] = dist[v] + next_w 

           heapq.heappush(heap, (dist[next_v], next_v))

for i in range(1, V + 1) : 
    if dist[i] == float('inf') : 
        print("INF")
    else : print(dist[i])


