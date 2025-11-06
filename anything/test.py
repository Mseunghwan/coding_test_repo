"""
1. 아이디어
 - MST 기본문제
 - 간선을 인접리스트에 집어넣기
 - 힙에 시작점 넣기
 - 힙이 빌때까지 다음의 작업을 반복
   - 힙의 최소값 꺼내서, 해당 노드 방문 안했는지 확인, 안했다면
       - 방문표시, 해당 비용 추가, 연결된 간선 힙에 넣어주기

2. 시간복잡도
 - MST : O(ElogE)

3. 자료구조
 - 간선들이 저장되는 인접리스트 : (무게, 노드번호)
 - 힙 : (무게, 노드번호)
 - 방문 여부 : bool[]
 - MST 결과값 : int
"""

import sys
import heapq

input = sys.stdin.readline

V, E = map(int, input().split())

# 그래프 공간 생성
graph = [[] for _ in range(V + 1)]
check = [False] * (V + 1)

# 인접리스트로 간선 표현해주기
for i in range(E) : 
    A, B, C = map(int, input().split())
    graph[A].append([C, B])
    graph[B].append([C, A])

rs = 0

heap = [[0,1]]
while heap : 
    # heap에서 하나씩 빼기
    w, next_node = heapq.heappop(heap)

    # 만약 방문하지 않은 곳이라면
    if check[next_node] == False :
        # 방문 표시를 하고
        check[next_node] = True
        # 비용을 결과에 더해주고
        rs += w
        # 그곳에서 갈 수 있는 곳을 검색해서
        for next_edge in graph[next_node] :
            # 안 간 곳이라면
            if check[next_edge[1]] == False : 
                # 힙에 추가해주자
                heapq.heappush(heap, next_edge)

print(rs)