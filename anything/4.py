import sys
from collections import deque

input = sys.stdin.readline

# 상, 하, 좌, 우 이동 방향
dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

def bfs(start_y, start_x, ground, visited):
    queue = deque([(start_y, start_x)])
    visited[start_y][start_x] = 0  # 목표 지점의 거리를 0으로 설정

    while queue:
        y, x = queue.popleft()

        for i in range(4):  # 네 방향 탐색
            nx = x + dx[i]
            ny = y + dy[i]

            # 범위를 벗어나지 않으면서 방문할 수 있는 곳만 탐색
            if 0 <= ny < len(ground) and 0 <= nx < len(ground[0]):
                if ground[ny][nx] == 0:  # 벽(0)은 방문 처리하지 않고 계속 0 유지
                    continue

                if visited[ny][nx] == -1 and ground[ny][nx] == 1:  # 방문하지 않은 길(1)
                    visited[ny][nx] = visited[y][x] + 1  # 거리 업데이트
                    queue.append((ny, nx))

# 입력 받기
y, x = map(int, input().split())
ground = [list(map(int, input().split())) for _ in range(y)]
visited = [[-1] * x for _ in range(y)]  # 방문 여부 초기화 (-1)

# 목표 위치(2) 찾기
start_y, start_x = -1, -1
for i in range(y):
    for j in range(x):
        if ground[i][j] == 2:
            start_y, start_x = i, j

# BFS 실행 및 결과 출력
if start_y != -1 and start_x != -1:
    bfs(start_y, start_x, ground, visited)

    # 갈 수 없는 땅(`1`)인데 BFS에서 방문하지 못한 곳은 `-1`로 유지 되어 있고,
    # 벽을 0으로 처리
    for i in range(y):
        for j in range(x):
            if ground[i][j] == 0:  # 벽(0) 유지
                visited[i][j] = 0

    # 출력
    for row in visited:
        print(*row)
else:
    print("목표 지점(2)이 없습니다.")
