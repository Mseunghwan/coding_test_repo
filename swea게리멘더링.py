import sys
from collections import deque

input = sys.stdin.readline

N = int(input())

maps = [0] + list(map(int, input().split()))

graph = [[] for _ in range(N + 1)]

for i in range(N) : 
    inputlst = list(map(int, input().split()))

    graph[i + 1] = inputlst[1:]

min_rs = float('inf')

def gerry(index, group1, group2) : 
    global min_rs
    # 종료조건
    if index == N + 1 :     
        if len(group1) > 0 and len(group2) > 0 :
            # DFS 로 연결성 확인 및 값 계산
            cnt_group1 = 0
            cnt_group2 = 0
            if check(group1) and check(group2) : 
                for i in group1 : 
                    cnt_group1 += maps[i] 

                for i in group2 : 
                    cnt_group2 += maps[i] 
        
                if min_rs > abs(cnt_group1 - cnt_group2) : 
                    min_rs = abs(cnt_group1 - cnt_group2)
        # return 위치 중요
        return
    
    # group1에 넣는 경우
    gerry(index + 1, group1 + [index], group2)

    # group2에 넣는 경우
    gerry(index + 1, group1, group2 + [index])

def check(group) : 
    if not group : 
        return False 
    
    set_group = set(group)
    st = group[0]
    # 방문 처리
    visited = [False] * (N + 1)
    visited[st] = True

    queue = deque([st])
    count = 1
    while queue :
        now = queue.popleft()

        for node in graph[now] : 
            if visited[node] == False and node in set_group : 
                count += 1
                queue.append(node)
                visited[node] = True

    return count == len(group)

gerry(1, [], [])
if min_rs == float('inf') : 
    print(-1)
else : 
    print(min_rs)