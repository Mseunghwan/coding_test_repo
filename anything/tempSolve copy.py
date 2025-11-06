"""

1. 아이디어
 - While 문으로, 특정조건 종료 될 때 까지 반복
 - 4 방향을 for문으로 탐색
 - 더 이상 탐색 불가한 경우, 뒤로 한 칸 후진
 - 후진 불가능 할 시 종료

2. 시간복잡도
 - O(NM) : 50^2 = 2500 < 2억

3. 자료구조
 - map : int[][]
 - 로봇청소기 위치, 방향, 전체 청소한 곳 수

"""
import sys

input = sys.stdin.readline

# 맵 크기
n, m = map(int, input().split())

# 청소기 위치
y, x, d = map(int, input().split())

maps = []
for i in range(n) : 
    maps.append(list(map(int, input().split())))

# 로봇 청소기 방향(북, 동, 남, 서)
dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]


cnt = 0
# 로봇 청소기 작동
while 1 : 
    
    # 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다
    if maps[y][x] == 0 :
        # 청소된 칸은 2로 표시, 
        # 왜? 후진 시 벽인 1이 아닌 경우에 이동할 수 있어야 하므로
        maps[y][x] = 2
        cnt += 1
    

    is_clean_spot = False
    # 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸 확인
    for i in range(4) : 
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= ny < n and 0 <= nx < m : 
            if maps[ny][nx] == 0 :
                is_clean_spot = True
                break

    
    # 있다면
    if is_clean_spot : 
        # 청소 가능한 방향 찾을 때 까지 회전
        while 1 : 

            # 반시계 방향으로 90도 회전
            d = (d - 1) % 4
        
            # 앞 칸 정소되지 않은 경우 한칸 전진 후 청소
            ny = y + dy[d]
            nx = x + dx[d]
            if 0 <= ny < n and 0 <= nx < m and maps[ny][nx] == 0: 
                y = ny
                x = nx
                break


    # 청소할 곳이 없다면 없다면
    else :
        # 바라보는 방향을 유지한 채로, 한 칸 후진
        back = (d + 2) % 4 # 뒤쪽 방향
        ny = y + dy[back]
        nx = x + dx[back]

        # 후진 할 수 있는지 확인
        if 0 <= ny < n and 0 <= nx < m and maps[ny][nx] != 1: 
            y = ny
            x = nx
        else : 
            # 후진 불가하다면 작동 멈춘다
            break

                
print(cnt)