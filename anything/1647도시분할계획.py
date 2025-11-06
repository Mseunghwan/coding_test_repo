import sys

input = sys.stdin.readline

# 집의 개수 N, 길의 개수 M
N, M = map(int, input().split())

# prim 과 달리 모든 edge들 중 최소를 찾아야 하기에 한 list로 관리
graph = []
result = 0

# 부모 테이블 자기자신으로 우선 초기화
parent = [0] * (N + 1)
for i in range(1, N + 1) : 
    parent[i] = i

for i in range(M) : 
    st, en, w = map(int, input().split())
    graph.append((w, st, en))

# 비용 순 정렬
graph.sort()

# 특정 원소가 속한 집합을 찾기
def find_parent(parent, x) : 
    # 루트 노드 찾을때 까지 재귀
    if parent[x] != x : 
        parent[x] = find_parent(parent, parent[x])
    
    return parent[x]

# 두 원소가 속한 집합을 합치기
def union_parent(parent, a, b) : 
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b : 
        parent[b] = a
    else : 
        parent[a] = b

max_w = 0

for edge in graph : 
    cost, a, b = edge
    # 사이클이 발생하지 않는 경우에만 집합에 포함
    if find_parent(parent, a) != find_parent(parent, b) : 
        union_parent(parent, a, b)
        max_w = max(max_w, cost)
        result += cost

print(result - max_w)