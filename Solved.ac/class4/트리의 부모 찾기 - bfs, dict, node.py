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