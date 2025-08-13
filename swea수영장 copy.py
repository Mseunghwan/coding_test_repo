T = int(input())

for case in range(T) : 
    cost = list(map(int, input().split()))

    schedule = list(map(int, input().split()))

    rs_min_cost = cost[3]

    def dfs(month, total) : 
        global rs_min_cost

        if month >= 12 : 
            if rs_min_cost > total : 
                rs_min_cost = total
                return
        
        if 0 <= month < 12 : 
            if schedule[month] == 0 : 
                dfs(month + 1, total)
            else : 
                for i in range(3) : 
                    if i == 0 : 
                        dfs(month + 1, total + schedule[month] * cost[0])
                    if i == 1 :
                        dfs(month + 1, total + cost[1])
                    if i == 2 : 
                        dfs(month + 3, total + cost[2])


    dfs(0, 0)

    print(f"#{case + 1} {rs_min_cost}")