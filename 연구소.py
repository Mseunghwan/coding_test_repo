import sys 
from collections import deque
import copy

input = sys.stdin.readline

N, M = map(int, input().split())

maps = []
for i in range(N) : 
    maps.append(list(map(int, input().split())))

min_rs = 0

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

def bfs() : 

    global min_rs

    graph = copy.deepcopy(maps)

    queue = deque()

    for i in range(N) : 
        for j in range(M) : 
            if graph[i][j] == 2 : 
                queue.append((i, j))

    while queue : 
        y, x = queue.popleft()

        for i in range(4) : 
            ny = y + dy[i] 
            nx = x + dx[i]

            if 0 <= ny < N and 0 <= nx < M and graph[ny][nx] == 0:
                graph[ny][nx] = 2
                queue.append((ny, nx))
    
    cnt = 0

    for i in range(N) : 
        for j in range(M) : 
            if graph[i][j] == 0 :
                cnt += 1

    if cnt > min_rs : 
        min_rs = cnt

# 백트래킹 활용
# 벽을 세개 세워야 하니까
def make_wall(cnt) : 
    if cnt == 3 :
        bfs()
        return
    
    for i in range(N) : 
        for j in range(M) :
            if maps[i][j] == 0 : 
                # 1 - 첫 벽을 세우는 과정
                maps[i][j] = 1
                # 2 - 두 번째 벽 세우러
                make_wall(cnt + 1)
                # 벽 허물고
                maps[i][j] = 0

make_wall(0)
print(min_rs)

