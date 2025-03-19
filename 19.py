import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

def dfs(y, x, h):
    for i in range(4):
        nx = dx[i] + x
        ny = dy[i] + y
        if 0 <= nx < N and 0 <= ny < N and maps[ny][nx] > h and visited[ny][nx] == False:
            visited[ny][nx] = True
            dfs(ny, nx, h)

N = int(input())
maps = []
for i in range(N):
    maps.append(list(map(int, input().split())))

# 최대 높이 구하기
max_h = max(map(max, maps))

max_area_cnt = 0
for h in range(max_h + 1):
    visited = [[False] * N for _ in range(N)]
    area_cnt = 0
    
    for i in range(N):
        for j in range(N):
            if maps[i][j] > h and not visited[i][j]:  # 방문하지 않은 안전 영역
                visited[i][j] = True
                dfs(i, j, h)
                area_cnt += 1

    max_area_cnt = max(max_area_cnt, area_cnt)  # 최대값 갱신
print(max_area_cnt)