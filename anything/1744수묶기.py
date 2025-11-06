import sys

input = sys.stdin.readline

N = int(input())

lst = []

for i in range(N) : 
    lst.append(int(input()))
    
lst.sort()

now_a = float('-inf')
now_b = float('-inf')
rs = 0
cnt = 0
visited = [False] * N
for i in range(N - 1, -1, -1 ) :
    if not visited[i] :  
        if lst[i] == 0 :
            visited[cnt] = True
            cnt += 1 
            continue
            
        if now_a != float('-inf') and now_b != float('-inf') :
                now_a = float('-inf')
                now_b = float('-inf')
            
            
        if lst[i] > 1 :
            if now_a != float('-inf') and now_b == float('-inf') :
                now_b = lst[i]
                rs += (now_b * now_a) 
            elif now_a == float('-inf') : 
                now_a = lst[i]
        visited[i] = True
        
for i in range(N) : 
    if lst[i] > 1 : 
        break
    rs += lst[i]
print(rs)


        
        