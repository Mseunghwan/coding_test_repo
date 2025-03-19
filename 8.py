import sys
from collections import deque

input = sys.stdin.readline

N, K = map(int, input().split())

ground = []
worms = []

for i in range(N):
    row = list(map(int, input().split()))
    ground.append(row)
    for j in range(N):
        if row[j] != 0:
            worms.append((row[j], i, j))  # (바이러스 번호, 행, 열)

S, X, Y = map(int, input().split())

dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

# 바이러스 번호 순으로 정렬 후 큐에 삽입
worms.sort()
queue = deque(worms)

def bfs(queue, ground):
    for _ in range(S):  # S초 동안 반복
        for _ in range(len(queue)):  # 현재 큐의 모든 요소를 한번씩 처리
            virus, y, x = queue.popleft()
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if 0 <= nx < N and 0 <= ny < N and ground[ny][nx] == 0:
                    ground[ny][nx] = virus
                    queue.append((virus, ny, nx))

bfs(queue, ground)

print(ground[X-1][Y-1])  # 1-based index 보정
