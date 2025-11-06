import sys


def dfs(lst, visited, start):
    while not visited[start]: # 만약 방문하지 않은 곳이라면
        visited[start] = True # 방문표시 해주고
        start = lst[start] # 다음 노드로 이동

# ----------------------------------------------- 시작 지점

input = sys.stdin.readline
T = int(input()) # T 개의 테스트 개수 입력 받음

for i in range(T): # T 개의 테스트 개수에 맞게 반복
    N = int(input()) 
    visited = [False] * (N + 1) # 요소의 개수인 N의 +1개 만큼 방문기록 리스트 생성
    lst = list(map(int, input().split()))
    lst.insert(0, 0) # 리스트를 받아오고, 1부터 가니까 0은 안쓰지만 채워져 있어야, 0번째에 0 넣기
    count = 0

    for i in range(1, N+1):
        if not visited[i]: # 만약 방문하지 않은 숫자라면
            dfs(lst, visited, i) # dfs를 돈다
            count += 1
    
    print(count)
