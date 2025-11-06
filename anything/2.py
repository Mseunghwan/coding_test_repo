import sys
from collections import deque



def bfs(node):
    visited = [-1] * (N + 1)
    # 거리를 추가
    queue = deque([node])
    visited[node] = 0
    farthest_node = 0

    while queue:
        togo = queue.popleft()
        for v, w in graph[togo]:
            if(visited[v] == -1):
                visited[v] = visited[togo] + w
                queue.append(v)
                if(visited[v] > visited[farthest_node]):
                    farthest_node = v
    return farthest_node, visited[farthest_node]

    
    

input = sys.stdin.readline

N = int(input())
graph = [[] for _ in range(N + 1)]
for i in range(N-1):
    v1, v2, w = map(int, input().split())
    graph[v1].append((v2, w))
    graph[v2].append((v1, w))


# first - 가장 먼 노드 찾기
node1, w = bfs(1)
w, node2 = bfs(node1)
print(node2)
