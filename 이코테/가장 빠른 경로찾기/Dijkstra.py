"""
# 쉽지만 높은 시간복잡도의 다익스트라
import sys

input = sys.stdin.readline
INF = int(1e9)

# n, m = 노드, 간선 개수 입력받기
n, m = map(int, input().split())

# 시작 노드 번호 입력받기
start = int(input())

# 각 노드에 연결된 노드에 대한 정보 담는 리스트
graph = [[] for _ in range(n + 1)]

# 방문 유무 리스트
visited = [False] * (n + 1)

# 최단 거리 테이블을 모두 무한으로 초기화
distance = [INF] * (n + 1)

# 모든 간선 정보 입력받기
for _ in range(m):
    # a번 노드에서 b번 노드로 가는 비용이 c라는 의미
    a, b, c = map(int, input().split())
    graph[a].append((b, c))

# 방문하지 않은 노드 중, 가장 최단 거리가 짧은 노드의 번호 반환
def get_smallest_node():
    min_value = INF
    index = 0 # 가장 최단 거리가 짧은 노드(인덱스)
    for i in range(1, n + 1):
        if distance[i] < min_value and not visited[i]:
            min_value = distance[i]
            index = i
    return index

def dijkstra(start):
    # 시작 노드 초기화
    distance[start] = 0
    visited[start] = True
    for j in graph[start] : 
        distance[j[0]] = j[1]
    
    # 시작 노드를 제외한 전체 n - 1 개의 노드에 대해 반복
    for i in range(n - 1):
        # 현재 최단 거리가 가장 짧은 노드를 꺼낸 후, 방문 처리
        now = get_smallest_node()
        visited[now] = True
        # 현재 노드와 연결된 다른 노드를 확인
        for j in graph[now]:
            cost = distance[now] + j[1]
            # 현재 노드를 거쳐 다른 노드로 이동하는 거리가 더 짧은 경우
            if cost < distance[j[0]]:
                distance[j[0]] = cost

# 다익스트라 알고리즘 호출
dijkstra(start)

# 모든 노드로 가기 위한 최단 거리를 출력
for i in range(1, n + 1):
    # 도달 할 수 없는 경우, 무한이라고 출력
    if distance[i] == INF:
        print("INFINITY")
    # 도달 가능 하면 거리 출력
    else:
        print(distance[i])

입력 : 
6 11
1
1 2 2
1 3 5
1 4 1
2 3 3
2 4 2
3 2 3
3 6 5
4 3 3
4 5 1
5 3 1
5 6 2

시간 복잡도 O(V^2)


"""

# 두 번째 다익스트라 - 시간복잡도 비교적 낮음
# 힙을 사용함, 힙? 우선순위 큐 구현하기 위해 쓰는 자료구조 --> Python 에서는 heapq 사용
import sys
import heapq 
input = sys.stdin.readline
INF = int(1e9)

# n, m = 노드, 간선 개수 입력받기
n, m = map(int, input().split())

# 시작 노드 번호 입력받기
start = int(input())

# 각 노드에 연결된 노드에 대한 정보 담는 리스트
graph = [[] for _ in range(n + 1)]

# 최단 거리 테이블을 모두 무한으로 초기화
distance = [INF] * (n + 1)

# 모든 간선 정보 입력받기
for _ in range(m):
    # a번 노드에서 b번 노드로 가는 비용이 c라는 의미
    a, b, c = map(int, input().split())
    graph[a].append((b, c))

def dijkstra(start):
    # 시작 노드로 가기 위한 최단 경로는 0으로 설정해, 큐에 삽입
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0
    while q: 
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue
        for i in graph[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))

# 다익스트라 알고리즘 호출
dijkstra(start)

# 모든 노드로 가기 위한 최단 거리를 출력
for i in range(1, n + 1):
    # 도달 할 수 없는 경우, 무한이라고 출력
    if distance[i] == INF:
        print("INFINITY")
    # 도달 가능 하면 거리 출력
    else:
        print(distance[i])

"""
입력 : 
6 11
1
1 2 2
1 3 5
1 4 1
2 3 3
2 4 2       
3 2 3
3 6 5
4 3 3
4 5 1
5 3 1
5 6 2

시간 복잡도 O(E log V)
"""


