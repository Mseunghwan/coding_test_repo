import heapq

T = int(input())

for case in range(T) : 

    N = int(input())

    x_lst = list(map(int, input().split()))
    y_lst = list(map(int, input().split()))
    E = float(input())

    dist = [float('inf')] * N

    visited = [False] * N
    heap = [[0, 0]] # 초기상태
    
    rs = 0
    nodes_in_mst = 0

    while heap : 
        w, v = heapq.heappop(heap)
        if visited[v] :
            continue

        # 방문처리
        visited[v] = True
        
        # 비용 더해주기
        rs += w

        for i in range(N) : 
            if not visited[i] : 
                val = (x_lst[v] - x_lst[i]) ** 2 + (y_lst[v] - y_lst[i]) ** 2 
                new_cost = val * E

                if new_cost < dist[i] : 
                    dist[i] = new_cost
                    heapq.heappush(heap, [new_cost, i])





    print(f"#{case + 1} {round(rs)}")