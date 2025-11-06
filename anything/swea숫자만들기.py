"""
아이디어 :
N개의 숫자 사이 N-1개의 연산자를 적용한 식의 결과가 최대가 되어야 하는 문제
--> DFS로 가능한 경우의 수를 따져보자
--> visited 처리는 연산자 개수에서 각 원소를 '-' 해주는거임
"""

T = int(input())
for case in range(T) :
    
    N = int(input())
    # 연산자 개수, 각 순 +, -, *, /
    operator = list(map(int, input().split()))

    # 숫자
    numbers = list(map(int, input().split()))

    max_one = float('-inf')
    min_one = float('inf')


    # 연산중인 항 값, number의 index 정보, operator(visited)
    def dfs(val, idx, opr, min_num) :
        global max_one, min_one
        lst = opr.copy()
        if idx != 1 :
            lst[min_num] -= 1

        # 종료조건 - 만약 idx == N
        if idx == N : 
            if val > max_one : 
                max_one = val

            if val < min_one : 
                min_one = val

            return
        
        # 가능한 경우의 수(연산자 적용) 돌아주기
        for i in range(4) : 
            if lst[i] != 0 :
                if i == 0 :
                    dfs(val + numbers[idx], idx + 1, lst, i)
                elif i == 1 :
                    dfs(val - numbers[idx], idx + 1, lst, i)
                elif i == 2 :
                    dfs(val * numbers[idx], idx + 1, lst, i)
                elif i == 3 :
                        dfs(int(val / numbers[idx]), idx + 1, lst, i)
        

    # 맨 첫 값은 numbers의 첫 항
    first = numbers[0]
    dfs(first, 1, operator, 0)
    print(f"#{case + 1} {max_one - min_one}")
