import sys

def dfs(index):
    global visited
    visited[index] = True
    print(index, end = " ")
    for i in range(1, N + 1):
        if (visited[i] == False) and (graph[index][i] == True):
            dfs(i)


def bfs(index):
    global q, visited
    # q 가 있을 때 까지
    while q:
        # 0번 인덱스 가져와서 i에
        cur = q.pop(0)
        print(cur, end = " ")
        for i in range(1, N+1):
            if (visited[i] == False) and (graph[cur][i] == True):
                visited[i] = True
                q.append(i)





input = sys.stdin.readline

# 입력받기
N, M, V= map(int, input().split())

graph = [[False] * (N + 1) for _ in range(N + 1)]
visited = [False] * (N + 1)
for i in range(M):
    a, b = map(int, input().split())
    graph[a][b] = True
    graph[b][a] = True

# dfs
dfs(V)
print()

# bfs
# dfs 이후므로 visited 초기화
visited = [False] * (N + 1)
# bfs 는 queue에서 하나씩 꺼내와서 쓰기에 시작 정점인 V를 넣어줌
q = [V]
visited[V] = True
bfs(V)