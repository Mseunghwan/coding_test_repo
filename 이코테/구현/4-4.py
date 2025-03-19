"""
정확히 내가 풀진 않음 ㅎㅎ;
"""
import sys

input = sys.stdin.readline

N, M = map(int, input().split())

# 캐릭터 위치 및 방향 입력
x, y, d = map(int, input().split())

# 맵 정보 입력
maps = [list(map(int, input().split())) for _ in range(N)]

# 방문 기록을 저장하는 배열
visited = [[False] * M for _ in range(N)]
visited[x][y] = True  # 현재 위치 방문 처리

# 방향 벡터 (북, 동, 남, 서)
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

# 왼쪽으로 회전하는 함수
def turn_left():
    global d
    d = (d - 1) % 4  # 0 -> 3, 1 -> 0, 2 -> 1, 3 -> 2

count = 1  # 시작 위치도 방문했으므로 1로 설정
turn_time = 0

while True:
    turn_left()
    nx, ny = x + dx[d], y + dy[d]

    # 가보지 않은 곳이면서 육지인 경우 이동
    if maps[nx][ny] == 0 and not visited[nx][ny]:
        visited[nx][ny] = True
        x, y = nx, ny
        count += 1
        turn_time = 0
        continue
    else:
        turn_time += 1

    # 네 방향 모두 갈 수 없는 경우, 뒤로 이동
    if turn_time == 4:
        nx, ny = x - dx[d], y - dy[d]
        if maps[nx][ny] == 0:  # 뒤가 육지라면 이동
            x, y = nx, ny
        else:  # 뒤가 바다라면 종료
            break
        turn_time = 0  # 다시 방향 탐색 초기화

print(count)
