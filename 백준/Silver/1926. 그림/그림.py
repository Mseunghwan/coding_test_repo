"""
1. 아이디어 : 
 - n * m인 맵 2중 for문으로 돌면서 값이 1 and 방문 X인 경우 BFS 함수 호출
 - BFS 돌면서 그림 갯수를 추가하고, 최댓값을 갱신

2. 시간복잡도 : 
 - BFS = O(V+E)
 - V :  m * n
 - E : 넉넉잡아 한 V당 4개의 경로(상하좌우) 갈 수 있으므로 4 * V
 - V+E : 500(m 최대) * 500(n 최대) = 250000 < 2억 가능!

3. 자료구조 : 
 - 그래프 전체지도 : int[][]
 - 방문 : bool
 - Queue(BFS)
"""

import sys
input = sys.stdin.readline

mapp = []
n, m = map(int, input().split())
for i in range(n):
    mapp.append(list(map(int, input().split())))

check = [[False] * m for _ in range(n)]
cnt = 0
maxone = 0



dy = [0, 1, 0, -1]
dx = [1, 0, -1, 0]
# dy, dx를 k로 함께 돌면 가장 앞이 오른쪽, 그 다음 아래, 그 다음 왼쪽, 그 다음 위
 
def bfs(y, x):
    rs = 1 
    # 그림의 사이즈
    q = [(y, x)]
    while(q):
        ey, ex = q.pop()
        for k in range(4):
            ny = ey + dy[k]
            nx = ex + dx[k]
            if 0<= ny < n and 0<= nx < m:
                if mapp[ny][nx] == 1 and check[ny][nx] == False:
                    rs += 1
                    check[ny][nx] = True
                    q.append((ny, nx))
    return rs


for i in range(n):
    for j in range(m):
        if(mapp[i][j] == 1 and check[i][j] == False):
            check[i][j] = True
            cnt += 1
            maxone = max(maxone, bfs(i, j))
print(cnt)
print(maxone)
