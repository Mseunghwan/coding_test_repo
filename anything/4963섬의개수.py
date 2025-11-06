import sys 
from collections import deque

input = sys.stdin.readline

dx = [1, 0, -1, 0, 1, -1, -1, 1]
dy = [0, -1, 0, 1, 1, -1, 1, -1]

while(True) :
    w, h = map(int, input().split())
    if w != 0 and h != 0 : 
        maps = []
        for i in range(h) : 
            maps.append(list(map(int, input().split())))
        
        where_at = []
        for i in range(h) : 
            for j in range(w) : 
                if maps[i][j] == 1 :
                    where_at.append((i, j))
        
        visited = [[False] * w for _ in range(h)] 

        def bfs(a, b) : 
            queue = deque([(a, b)])
            visited[a][b] = True
            while queue : 
                y, x = queue.popleft()
                for i in range(8) : 
                    ny = y + dy[i]
                    nx = x + dx[i]

                    if 0 <= ny < h and 0 <= nx < w : 
                        if visited[ny][nx] == False and maps[ny][nx] == 1 : 
                            visited[ny][nx] = True
                            queue.append((ny, nx))




        cnt = 0
        for i in range(len(where_at)) : 
            if visited[where_at[i][0]][where_at[i][1]] : 
                continue
            bfs(where_at[i][0], where_at[i][1])
            cnt += 1


        print(cnt)
    else : 
        break
