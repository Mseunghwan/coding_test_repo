"""
아이디어 : 깊이 우선 탐색
--> 이유? map을 탐색하며 대각선 방향으로 움직여 겹치지 않는 카페 순회
--> 각각 탐색 케이스를 고려해야 하므로, DFS 활용

제약사항
1. 대각선 방향으로 움직이고, 사각형 모양을 그리며 출발한 카페로 돌아와야
2. 카페 투어 중 같은 숫자의 디저트를 팔고 있는 카페가 있으면 안된다
3. 한 카페 혹은 왔던 길을 돌아가는 것도 금지
4. 되도록 많이 먹어라(디저트 종류가 가장 많은 탐색)
"""

T = int(input())
for case in range(T) : 
    N = int(input())
    maps = []

    for i in range(N) : 
        maps.append(list(map(int, input().split())))
    
    # 디저트 먹은 최대 회수
    max_one = 0

    # 카페 투어의 방향
    dx = [1, -1, -1, 1]
    dy = [1, 1, -1, -1]

    def dfs(y, x, path, d) : 
        global max_one, st_y, st_x

        # 종료조건 : 만약 d가 4 이상이라면 return
        if d >= 4 :
            return
        
        ny = y + dy[d]
        nx = x + dx[d]

        # 종료조건 - 만약 d가 3일때, 출발 지점으로 도착, max_one 갱신, 
        if d == 3 and nx == st_x and ny == st_y :
            if len(path) >= 4 : 
                if len(path) > max_one : 
                    max_one = len(path)
                    return
            
        if 0 <= ny < N and 0 <= nx < N and maps[ny][nx] not in path : 
            dfs(ny, nx, path + [maps[ny][nx]], d)
        
        dfs(y, x, path, d + 1)

        return


    for i in range(N) : 
        for j in range(N) : 
            st_y = i
            st_x = j
            dfs(i, j, [maps[i][j]], 0)
    
    if max_one == 0 :
        print(f"#{case + 1} {-1}")
    else :
        print(f"#{case + 1} {max_one}")

