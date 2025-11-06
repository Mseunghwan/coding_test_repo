from pprint import pprint
T = int(input())

for case in range(T) : 
    N, M, R, C, L = map(int, input().split())

    maps = []

    for i in range(N) : 
        maps.append(list(map(int, input().split())))    
    
    dx = [1, 0, -1, 0]
    dy = [0, 1, 0, -1]

    def bfs(a, b, time) : 
        queue = [(a, b, 1)]

        while queue : 
            y, x, t = queue.pop(0)
            # 탈출 소요 시간 다되면 다음 큐 넘겨
            if t == time : 
                continue

            for i in range(4) : 
                ny = y + dy[i] 
                nx = x + dx[i]

                if 0 <= ny < N and 0 <= nx < M and maps[ny][nx] != 0 and visited[ny][nx] == False : 
                    if maps[ny][nx] == 1 :
                        # 만약 왼쪽에서부터 왔다면?
                        if dx[i] == 1 and maps[y][x] in (1, 3, 4, 5) : 
                            visited[ny][nx] = True
                            queue.append((ny, nx, t + 1))
                        # 만약 오른쪽에서부터 왔다면?
                        elif dx[i] == -1 and maps[y][x] in (1, 3, 6, 7) : 
                            visited[ny][nx] = True
                            queue.append((ny, nx, t + 1))
                        # 만약 위에서부터 왔다면?
                        elif dy[i] == 1 and maps[y][x] in (1, 2, 5, 6) : 
                            visited[ny][nx] = True
                            queue.append((ny, nx, t + 1))
                        # 만약 아래에서부터 왔다면?
                        elif dy[i] == -1 and maps[y][x] in (1, 2, 4, 7) : 
                            visited[ny][nx] = True
                            queue.append((ny, nx, t + 1))
                    
                    elif maps[ny][nx] == 2 :
                        if dy[i] == 1 and maps[y][x] in (1, 2, 5, 6) : 
                            visited[ny][nx] = True
                            queue.append((ny, nx, t + 1))
                        # 만약 아래에서부터 왔다면?
                        elif dy[i] == -1 and maps[y][x] in (1, 2, 4, 7) : 
                            visited[ny][nx] = True
                            queue.append((ny, nx, t + 1))

                    if maps[ny][nx] == 3 :
                        # 만약 왼쪽에서부터 왔다면?
                        if dx[i] == 1 and maps[y][x] in (1, 3, 4, 5) : 
                            visited[ny][nx] = True
                            queue.append((ny, nx, t + 1))
                        # 만약 오른쪽에서부터 왔다면?
                        elif dx[i] == -1 and maps[y][x] in (1, 3, 6, 7) : 
                            visited[ny][nx] = True
                            queue.append((ny, nx, t + 1))
                    
                    if maps[ny][nx] == 4 :
                        # 만약 오른쪽에서부터 왔다면?
                        if dx[i] == -1 and maps[y][x] in (1, 3, 6, 7) : 
                            visited[ny][nx] = True
                            queue.append((ny, nx, t + 1))
                        # 만약 위에서부터 왔다면?
                        elif dy[i] == 1 and maps[y][x] in (1, 2, 5, 6) : 
                            visited[ny][nx] = True
                            queue.append((ny, nx, t + 1))
                        
                    if maps[ny][nx] == 5 :
                        # 만약 오른쪽에서부터 왔다면?
                        if dx[i] == -1 and maps[y][x] in (1, 3, 6, 7) : 
                            visited[ny][nx] = True
                            queue.append((ny, nx, t + 1))
                        # 만약 아래에서부터 왔다면?
                        elif dy[i] == -1 and maps[y][x] in (1, 2, 4, 7) : 
                            visited[ny][nx] = True
                            queue.append((ny, nx, t + 1))
                    
                    if maps[ny][nx] == 6 :
                        # 만약 왼쪽에서부터 왔다면?
                        if dx[i] == 1 and maps[y][x] in (1, 3, 4, 5) : 
                            visited[ny][nx] = True
                            queue.append((ny, nx, t + 1))
                        # 만약 아래에서부터 왔다면?
                        elif dy[i] == -1 and maps[y][x] in (1, 2, 4, 7) : 
                            visited[ny][nx] = True
                            queue.append((ny, nx, t + 1))
                    
                    if maps[ny][nx] == 7 :
                        # 만약 왼쪽에서부터 왔다면?
                        if dx[i] == 1 and maps[y][x] in (1, 3, 4, 5) : 
                            visited[ny][nx] = True
                            queue.append((ny, nx, t + 1))
                        # 만약 위에서부터 왔다면?
                        elif dy[i] == 1 and maps[y][x] in (1, 2, 5, 6) : 
                            visited[ny][nx] = True
                            queue.append((ny, nx, t + 1))
                            

    visited = [[False] * M for _ in range(N)]
    visited[R][C] = True
    bfs(R, C, L)


    sum = 0
    for i in range(N) : 
        for j in range(M) : 
            if visited[i][j] == True : 
                sum += 1

    print(f"#{case + 1} {sum}")
                    


# 전처리로 가능할 줄 알았으나.. 안풀린다
    # def maps_convert(map_copy) : 
    #     rs_map = [[0] * M for _ in range(N)]

    #     for i in range(N) : 
    #         for j in range(M) : 
    #             if map_copy[i][j] == 1 : 
    #                 # 상, 하, 좌, 우 터널 뚫어주기(맵을 1로)
    #                 # 상, 하, 좌, 우 순
    #                 if 0 <= i - 1 and map_copy[i-1][j] in(1,  2, 5, 6):
    #                     # 상
    #                     rs_map[i - 1][j] = True
    #                 if i + 1 < N and map_copy[i + 1][j] in(1,  2, 4, 7):
    #                     # 하
    #                     rs_map[i + 1][j] = True
    #                 if 0 <= j - 1 and map_copy[i][j - 1] in(1, 3, 4, 5):
    #                     # 좌
    #                     rs_map[i][j - 1] = True
    #                 if j + 1 < M and map_copy[i][j + 1] in (1, 3, 6, 7) :
    #                     # 우
    #                     rs_map[i][j + 1] = True
    #             elif map_copy[i][j] == 2 : 
    #                 if 0 <= i - 1 and map_copy[i-1][j] in(1,  2, 5, 6):
    #                     # 상
    #                     rs_map[i - 1][j] = True
    #                 if i + 1 < N and map_copy[i + 1][j] in(1,  2, 4, 7):
    #                     # 하
    #                     rs_map[i + 1][j] = True
                   
    #             elif map_copy[i][j] == 3 : 
    #                 if 0 <= j - 1 and map_copy[i][j - 1] in(1, 3, 4, 5):
    #                     # 좌
    #                     rs_map[i][j - 1] = True
    #                 if j + 1 < M and map_copy[i][j + 1] in (1, 3, 6, 7) :
    #                     # 우
    #                     rs_map[i][j + 1] = True
    #             elif map_copy[i][j] == 4 : 
    #                 if 0 <= i - 1 and map_copy[i-1][j] in(1,  2, 5, 6):
    #                     # 상
    #                     rs_map[i - 1][j] = True
    #                 if j + 1 < M and map_copy[i][j + 1] in (1, 3, 6, 7) :
    #                     # 우
    #                     rs_map[i][j + 1] = True

    #             elif map_copy[i][j] == 5 : 
    #                 if i + 1 < N and map_copy[i + 1][j] in(1,  2, 4, 7):
    #                     # 하
    #                     rs_map[i + 1][j] = True
    #                 if j + 1 < M and map_copy[i][j + 1] in (1, 3, 6, 7) :
    #                     # 우
    #                     rs_map[i][j + 1] = True

    #             elif map_copy[i][j] == 6 : 
    #                 if i + 1 < N and map_copy[i + 1][j] in(1,  2, 4, 7):
    #                     # 하
    #                     rs_map[i + 1][j] = True
    #                 if 0 <= j - 1 and map_copy[i][j - 1] in(1, 3, 4, 5):
    #                     # 좌
    #                     rs_map[i][j - 1] = True
                    
    #             elif map_copy[i][j] == 7 : 
    #                 if 0 <= i - 1 and map_copy[i-1][j] in(1,  2, 5, 6):
    #                     # 상
    #                     rs_map[i - 1][j] = True
    #                 if 0 <= j - 1 and map_copy[i][j - 1] in(1, 3, 4, 5):
    #                     # 좌
    #                     rs_map[i][j - 1] = True
                   
    #     return rs_map
