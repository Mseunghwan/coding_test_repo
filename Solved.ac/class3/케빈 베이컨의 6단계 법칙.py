import sys
from collections import deque

input = sys.stdin.readline

n, m = map(int, input().split())

maps = [[] for _ in range(n + 1)]
for i in range(m):
    a, b = map(int, input().split())
    maps[a].append(b)
    maps[b].append(a)

answer = []
def bfs(start):
    cnt = 0

    visited = [False] * (n + 1)
    visited[start] = True

    queue = deque([])
    queue.append((0, start)) # 이동횟수, 출발점

    while queue : 
        count, cur = queue.popleft()

        for next in maps[cur] : 
            if not visited[next] : 
                visited[next] = True
                queue.append((count + 1, next))
                
        cnt += count

    answer.append((cnt, start))


for i in range(1, n + 1):
    bfs(i)

answer.sort()

print(answer[0][1])