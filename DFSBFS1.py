import sys
from collections import deque
input = sys.stdin.readline

puzzle = []
zero = (0, 0)
for i in range(3):
    puzzle += list(map(int, input().split()))

start = "".join(map(str, puzzle))
goal = "123456780"

dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

def bfs(start, goal):
    q = deque() # 현재 상태, 0의 위치, 움직인 횟수
    q.append((start, start.index("0"), 0))
    visited = set()
    visited.add(start) # visited는 문자열을 저장하고, 해당 문자열을 다시 방문하지않게 하는거

    while q:
        start, zero_idx, moves = q.popleft()
        if(start == goal):
            return moves

        # 현재 0 의 위치를 행, 열로 변환
        y, x = zero_idx // 3, zero_idx % 3
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0<=nx<3 and 0<=ny<3:
                new_idx = ny * 3 + nx

                new_start = list(start)
                new_start[zero_idx], new_start[new_idx] =  new_start[new_idx], new_start[zero_idx] 
                new_start = "".join(new_start)

                if new_start not in visited:
                    visited.add(new_start)
                    q.append((new_start, new_idx, moves + 1))

    return -1

print(bfs(start, goal))
