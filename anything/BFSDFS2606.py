import sys

input = sys.stdin.readline

def dfs(go, visited, start):
    visited[start] = True # 방문 표시(인접노드임을 확인)
    for next in go[start]: # go에서 값을 가져와서
        if not visited[next]: # 만약 방문하지 않은 정점이라면 
            dfs(go, visited, next) # 계속 요소들을 돌며 visit 찍어준다

N = int(input())  # 컴퓨터 수
con = int(input())  # 연결된 쌍의 수

go = [[] for _ in range(N + 1)]  # 인접 리스트 방식으로 그래프 저장
visited = [False] * (N + 1)  # 방문 여부 배열

for _ in range(con):
    a, b = map(int, input().split())
    go[a].append(b)  # 양방향 연결
    go[b].append(a)

dfs(go, visited, 1) # 1번 컴퓨터에서만 웜 바이러스가 걸리기에 start 1
print(sum(visited) - 1)