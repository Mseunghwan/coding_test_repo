"""
1. 아이디어
 - 한점시작, 모든 거리 : 다익스트라
 - 간선, 인접 리스트 저장
 - 거리배열 무한대 초기화
 - 시작점 : 거리배열 0, 힙에 넣어주기
 - 힙에서 빼면서 다음의 것 수행
   - 최신 값인지 먼저 확인
   - 간선을 타고 간 비용이 더 작으면 갱신

2. 시간복잡도
 - 다익스트라 : O(ElogV)
 - E : 3e5
 - V : 2e4, logV ~= 20
 - ElogV = 6e6 > 가능

3. 변수
 - 힙 : (비용, 노드번호)
 - 거리 배열 : 비용 : int[]
 - 간선 저장, 인접 리스트 : (비용, 노드번호)[]
"""
import sys
import heapq

INF = sys.maxsize

input = sys.stdin.readline

# 정점 수(V)와 간선 수(E)
V, E = map(int, input().split())

# 시작 점 K
K = int(input())

edge = [[] for _ in range(V + 1)]
dist = [INF] * (V + 1) 

for i in range(E) : 
    # u에서 v로 가는 가중치 w인 간선이 존재하는 것
    u, v, w = map(int, input().split())
    edge[u].append((w, v))

# 시작점을 0으로 초기화
dist[K] = 0

# 힙에 초기 노드 넣어준다
heap = [[0, K]]

while heap : 
    # 현재 시점에서 가장 거리가 짧은 노드 정보를 힙에서 꺼냄
    w, v = heapq.heappop(heap)
    
    # 최적화: 힙에서 꺼낸 거리(w)가 이미 저장된 최단 거리(dist[v])보다 크면,
    # 이 경로는 더 짧은 경로에 의해 이미 갱신된 "오래된" 정보이므로 무시하고 다음으로 넘어감
    if w != dist[v] : 
        continue
    
    # 현재 노드(v)와 연결된 모든 이웃 노드(nv)를 확인 (경로 완화, relaxation)
    for nw, nv in edge[v] : 
        # 현재 노드를 거쳐 이웃 노드로 가는 경로의 비용(dist[v] + nw)이
        # 기존에 알려진 이웃 노드까지의 최단 비용(dist[nv])보다 짧은지 확인
        if dist[nv] > dist[v] + nw : 
            # 더 짧은 경로를 발견하면, 최단 거리를 갱신
            dist[nv] = dist[v] + nw
            # 갱신된 정보를 (새로운 거리, 이웃 노드) 형태로 힙에 추가하여,
            # 이 경로를 바탕으로 한 추가 탐색이 이루어지도록 함
            heapq.heappush(heap, [dist[nv], nv])

for i in range(1, V + 1) : 
    if dist[i] == INF : 
        print("INF")
    else : print(dist[i])
    
    

    
