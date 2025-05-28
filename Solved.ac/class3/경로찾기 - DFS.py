import sys

input = sys.stdin.readline

n = int(input())

graph = []
visited = [False] * n
for i in range(n):
    graph.append(list(map(int, input().split())))

def dfs(x) : 
    # x번째 정점과 나머지 정점들 비교
    for i in range(n):
        if graph[x][i] == 1 and visited[i] == False :
            visited[i] = True
            dfs(i)


for i in range(n):
    # 처음 정점부터 시작
    dfs(i)
    # dfs 후, 인접행렬 돌면서 출력
    for j in range(n):
        if visited[j] == True : 
            print(1, end = " ")
        else :
            print(0, end = " ")
    print()
    visited = [False] * n



