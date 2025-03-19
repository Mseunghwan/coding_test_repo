import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

def dfs(start, end, cnt):
    visited[start] = True
    if start == end:
        return cnt
    else:

        for v, w in graph[start]:
            if(not visited[v]):
                result = dfs(v, end, cnt + w)
                if result is not None:
                    return result

N, M = map(int, input().split())
graph = [[] for _ in range(N + 1)]
for i in range(N-1):
    v1, v2, w = map(int, input().split())
     # 인접 리스트로
    graph[v1].append((v2, w))
    graph[v2].append((v1, w))

letsgo = []
for i in range(M):
    N2, M2 = map(int, input().split())
    letsgo.append((N2, M2))

for start, end in letsgo:
    visited = [False] * (N + 1)
    result = dfs(start, end, 0)
    print(result)
    
