"""
1. 아이디어 : 
 - 가족 관계 family 2차원 배열로 표현, BFS로 visit 횟수 계산

2. 시간복잡도 : 
 - BFS = O(V+E)
 - V : n
 - E : m
 - V+E : n + m = O(100 + 99)

3. 자료구조 : 
 - 그래프 전체지도 : int[][]
 - 방문 : int[]
 - Queue(BFS)
"""

import sys
from collections import deque
input = sys.stdin.readline

n = int(input())

family = [[] for _ in range(n+1)]
visit = [0 for _ in range(n+1)]
x, y = map(int, input().split())
k = int(input())


for i in range(k):
    a, b = map(int, input().split())
    family[a].append(b)
    family[b].append(a)

def bfs(x, y):
    queue = deque([x])
    while(queue):
        man = queue.popleft()

        if man == y:
            return visit[y]

        for i in family[man]:
            if visit[i] == 0:
                queue.append(i)
                visit[i] = visit[man] + 1
    return -1

print(bfs(x, y))