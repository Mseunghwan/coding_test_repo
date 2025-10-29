import sys
import heapq

input = sys.stdin.readline

T = int(input())

# prim 써서

for i in range(T) :
    N, M = map(int, input().split())

    graph = [[] * (N + 1) for _ in range(N + 1)]
    visited = [False] * (N + 1)
    for j in range(M) :
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)

    # 1에서 시작
    heap = [1]
    visited[1] = True
    # 비행기 카운트
    cnt = 0
    while(heap) :
        v = heapq.heappop(heap)

        for next in graph[v] :
            if visited[next] == False :
                visited[next] = True
                heapq.heappush(heap, next)
                cnt += 1
    print(cnt)