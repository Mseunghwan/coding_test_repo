T = int(input())

for case in range(T) : 

    cost_lst = list(map(int, input().split()))

    schedule = list(map(int, input().split()))

    # 1년 권 가격으로 최소가격을 초기화 시키고 시작
    min_total_cost = cost_lst[3]

    # 가능한 모든 경우의 수 탐색하기 위해 DFS를 씁시다유,,
    def dfs(month, total) :
        global min_total_cost
        # 종료조건
        if month >= 12 : 
            if min_total_cost > total : 
                min_total_cost = total
            
        
        if 0 <= month < 12 : 

            if schedule[month] == 0 : 
                dfs(month + 1, total)

            else : 
                # 가능한 모든 경우의 수 탐색
                for i in range(3) : 
                
                    if i == 0 :
                        if schedule[month] != 0 :
                            dfs(month + 1, total + schedule[month] * cost_lst[0])
            
                    if i == 1 :
                        if schedule[month] != 0 :
                            dfs(month + 1, total + cost_lst[1])
            
                    if i == 2 :
                        if schedule[month] != 0 :
                            dfs(month + 3, total + cost_lst[2])
            
    dfs(0, 0)
    print(f"#{case + 1} {min_total_cost}")
            
                
    
