T = int(input())

for case in range(T) : 
    # day, month, 3-month, year
    cost = list(map(int, input().split())) 

    schedule = list(map(int, input().split()))

    # 가장 큰 단위인 1년 비용으로 초기화
    min_cost = cost[3] 

    def dfs(x, total) : 

        global min_cost
        # 종료조건 : x가 12 혹은 그 이상일 때
        if x >= 12 : 
            if min_cost > total : 
                min_cost = total
                return 

        # for 문 돌면서 각 가능한 수를 깊이우선탐색
        for i in range(3) : 
            if x <= 11 :
                if i == 0 : 
                    dfs(x + 1, total + (schedule[x] * cost[i]))
                elif i == 1 :
                    dfs(x + 1, total + cost[i])
                elif i == 2 :
                    dfs(x + 3, total + cost[i])
            
        return 

    dfs(0, 0)

    print(f"#{case + 1} {min_cost}")

