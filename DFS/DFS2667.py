'''
1. 아이디어
 - 2중 for문 돌면서, 값이 1인 것 && 방문X => DFS
 - DFS를 통해 값 찾은 것 cnt 후 정렬 해 리턴

2. 시간복잡도
 - DFS : O(V+E)
 - V, E = N^2, 4N^2
 - V+E = 5N^2 = N^2 --> 25 * 25 = 625 < 2억 보다 한참 아래

3. 자료구조
 - 그림 ground 2차원 배열
 - 방문여부 bool 2차원 
 - 결과값 저장 int list cnt [] 
'''

import sys

input = sys.stdin.readline

n = int(input())

ground = []
visit = [[False] * n for _ in range(n)]
cnt = []
for i in range(n):
    ground.append(list(map(int, input().strip())))


each = 0

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

def dfs(y, x):
    global each
    each += 1
    for k in range(4):
        nx = x + dx[k]
        ny = y + dy[k]
        if(0<=nx<n and 0<=ny<n):
            if(ground[ny][nx] == 1 and visit[ny][nx] == False):
                visit[ny][nx] = True
                dfs(ny, nx)
            
                 
for i in range(n):
    for j in range(n):
        if(ground[i][j] == 1 and visit[i][j] == False):
            visit[i][j] = True
            each = 0 
            dfs(i, j)
            cnt.append(each)

cnt.sort() 
print(len(cnt))
for i in cnt:
    print(i)

