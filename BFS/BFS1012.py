"""
1. 아이디어 : 
문제 핵심:

배추들이 인접한 그룹의 수를 세어야 하므로, 그래프 탐색 문제로 접근.
배추밭을 2D 그래프로 보고, 각 배추(1)에 대해 BFS를 수행해 인접한 배추들을 방문 처리.
방문한 배추들은 동일한 그룹으로 간주.
BFS가 한 번 수행될 때마다 필요한 지렁이 수를 1 증가.

배추밭 크기와 배추 위치 정보를 입력받아 2D 리스트(ground)에 배추(1) 위치 표시.
방문 여부를 확인하기 위해 check 2D 리스트 사용.
배추밭의 각 위치를 순회하며, 배추(1)이면서 방문하지 않은 곳에서 BFS를 시작.
BFS를 통해 인접한 배추들을 모두 방문 처리.
BFS를 한 번 수행할 때마다 지렁이 수(cnt)를 1 증가.
모든 그룹의 탐색이 끝나면 cnt 출력.
2. 시간복잡도 : 
모든 배추(K)를 한 번씩 탐색하며, 각 탐색에서 4방향(상하좌우)을 확인.
BFS의 시간복잡도는 O(K+E), 여기서 E는 간선의 개수(최대 4K).
따라서 한 테스트 케이스의 시간복잡도는 O(K).
전체 시간복잡도: 테스트 케이스 수 T에 대해 O(TxK). 최대 2500x50=125,000, 충분히 처리 가능.
3. 자료구조 :
배추밭 정보 (ground): MxN 크기의 2D 리스트로, 배추 위치를 1로 표시.
방문 체크 (check): MxN 크기의 2D 리스트로, 방문 여부를 True/False로 관리.
큐 (queue): BFS 탐색을 위한 큐. O(K) 공간 필요.
"""

import sys
input = sys.stdin.readline
from collections import deque

dy = [0, 1, 0, -1]
dx = [1, 0, -1, 0]
# dy, dx를 k로 함께 돌면 가장 앞이 오른쪽, 그 다음 위, 그 다음 왼쪽, 그 다음 아래

def bfs(yy, xx):
    queue = deque([(yy, xx)])
    while(queue):
        ey, ex = queue.popleft()
        for k in range(4):
            ny = ey + dy[k]
            nx = ex + dx[k]
            if 0<=ny<y and 0<=nx<x:
                if ((ground[ny][nx] == 1) and (check[ny][nx] == False)):
                    check[ny][nx] = True
                    queue.append((ny, nx))
            
    return 1


t = int(input())

for _ in range(t):
    cnt = 0
    x, y, w = map(int, input().split())
    ground = [[0] * x for _ in range(y)]
    for i in range(w):
        a, b = map(int, input().split())
        ground[b][a] = 1

    check = [[False] * x for _ in range(y)]

    for i in range(y):
        for j in range(x):
            if(ground[i][j] == 1 and check[i][j] == False):
                check[i][j] = True
                bfs(i, j)     
                cnt += 1 

    print(cnt)