T = int(input())

for case in range(T) : 
    N = int(input())

    maps = []
    for i in range(N) : 
        maps.append(list(map(int, input().split())))

    # 디저트 먹은 최대 횟수(정답)
    max_one = 0

    # 카페 투어의 방향은 우하, 좌하, 좌상, 우상 순으로 고정
    dx = [1, -1, -1, 1]
    dy = [1, 1, -1, -1]

    # y좌표, x좌표, 거쳐온 경로, 현재 d
    def dfs(y, x, path, d) : 
        global max_one, st_y, st_x

        # 종료조건 - 만약 d가 4 이상이라면 종료
        if d >= 4 :
            return

        ny = y + dy[d]
        nx = x + dx[d]

        # 종료조건 - 만약 d가 3인 때, 출발지점으로 도착했을 때, 4개 이상의 경로를 거쳐왔다면
        if d == 3 and nx == st_x and ny == st_y: 
            if len(path) >= 4 :
                if len(path) > max_one : 
                    # print(path)
                    max_one = len(path)
                    return
            

        # 탐색 조건, 사이즈 내에 있으면서 기존에 안가본 path인 경우
        if 0 <= ny < N and 0 <= nx < N and maps[ny][nx] not in path : 
            # 경로 추가 후,
            # 더 가는 경우와 방향 이동하는 경우 두 가지로 나누어 재귀호출
            dfs(ny, nx, path + [maps[ny][nx]], d)
        
        # 위 조건과 무관하게 방향 바꾸고 깊이 탐색
        dfs(y, x, path, d + 1)
        
        return
             


    # 각 위치에서, 카페 투어 시작
    for i in range(N) : 
        for j in range(N) : 
            st_y = i
            st_x = j
            dfs(i, j, [maps[i][j]], 0)

    if max_one == 0:
        print(f"#{case + 1} {-1}")
    else : 
        print(f"#{case + 1} {max_one}")