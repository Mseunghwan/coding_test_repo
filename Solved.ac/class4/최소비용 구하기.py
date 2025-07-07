import sys
from collections import defaultdict
import heapq 

# 이 부분은 재학습 필요하다
input = sys.stdin.readline

n = int(input()) # bus
m = int(input()) # city

graph = defaultdict(list)

for i in range(m) :
    a, b, c = map(int, input().split())
    graph[a].append((b, c)) # 거리 저장

start, end = map(int, input().split()) # 출발 지점과 도착 지점

# Dijkstra 로 풀어야 한다
"""
다익스트라 --> 어떤 노드에서 어떤 노드까지 얼마나 걸릴지 모르는 수치는 다 INF(무한대로)
우선순위 큐를 사용한다
이후, 비용 초기화를 해주고, 다익스트라 알고리즘 시작. 우선순위 큐를 사용한다
"""

# distance는 시작점 기준, 각 노드마다 최소비용 저장하는 리스트
# 최소 비용 초기화
INF = float('inf')
distance = [INF] * (n + 1)
distance[start] = 0

# 다익스트라: 우선순위 큐 사용
heap = []
heapq.heappush(heap, (0, start))  # (비용, 현재노드)

while heap:
    curr_cost, curr = heapq.heappop(heap) # 비용, 현재노드 꺼내기

    # 이미 더 짧은 거리로 distance가 저장되어 있으면 
    # 더 많은 비용 들일 필요없으니 다음 노드 꺼내기
    if curr_cost > distance[curr]:
        continue

    # 그래프에서 현재 노드의 비용 꺼내서 total cost에 next_cost와 더해주는거
    for next_node, next_cost in graph[curr]:
        total_cost = curr_cost + next_cost
        # 만약 total_cost가 distance에 저장된 해당 노드까지의 거리보다 짧으면
        # distance에 total_cost 넣어주기
        if total_cost < distance[next_node]:
            distance[next_node] = total_cost
            # 힙 갱신
            heapq.heappush(heap, (total_cost, next_node))
    print(distance)

print(distance[end])