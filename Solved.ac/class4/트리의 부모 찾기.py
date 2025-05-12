import sys
from collections import deque, defaultdict

input = sys.stdin.readline

n = int(input())
node = defaultdict(list)
for i in range(n - 1):
    a, b = map(int, input().split())
    node[a].append(b)
    node[b].append(a)
    
visited = set()

# bfs 활용, 루트인 1 부터
queue = deque([1])
visited.add(1)
parent = {}

while queue:
    now = queue.popleft()
    for next_node in node[now] :
        if next_node not in visited :
            parent[next_node] = now
            visited.add(next_node)
            queue.append(next_node)

for i in range(2, n + 1):
    print(parent[i])
    

"""
✅ 개념 설명 (왜 찾을 수 있는가?)
트리는 사이클이 없다.

한 노드와 연결된 모든 노드는 "자식일 수도 있고 부모일 수도 있다".

근데 1번 노드는 무조건 루트라고 문제에서 고정했다.

그래서 1번부터 연결된 노드를 방문하면 그 노드는 1번의 자식인 거다.

그 자식 노드를 기준으로 또 연결된 노드들을 보면:

이미 방문한 애(부모였던 애)는 제외

안 가본 애들은 "그 자식의 자식들"인 거지.

그냥 트리 구조를 밑으로 타고 내려가면서 부모를 기록하면 되는 거야.
"""
