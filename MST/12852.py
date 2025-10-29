import sys
import heapq
from math import sqrt

input = sys.stdin.readline

N, M = map(int, input().split())

# 거리 찾기 함수
def get_dist(x1, y1, x2, y2) :
    return sqrt((x1-x2)**2 + (y1-y2)**2)
    
# 1 부터 시작하도록 더미데이터 넣고 시작
gods = [[0, 0]]

# 각 위치 입력
for i in range(N) : 
    gods.append(list(map(int, input().split())))
    
graph = [[] * (N + 1) for _ in range(N + 1)]


# 기존 연결 그래프 입력
for i in range(M) :
    a, b = map(int, input().split()) 
    graph[a].append(b)
    graph[b].append(a)
    
visited= [False] * (N + 1)

# 힙 시작에 처음 시작 노드로 1 선정
heap = [(0.0, 1)]

# 몇 개 연결되어 있는지 --> 모든 노드 연결 유무 확인용
connect = 0
# 총 비용
rs = 0

# 힙 존재 and 연결될 때 까지
while heap and connect < N:
    
    # 비용, 노드 
    cost, v = heapq.heappop(heap)
    
    # 이미 방문 했던 곳이라면 넘기고
    if visited[v] :
        continue
    
    # 방문 안했다면 방문 처리 후 cost 더해주기(heap 이기에 바로 더해도 최소값)
    visited[v] = True
    rs += cost
    # 방문 갯수에 추가
    connect += 1
    
    
    # 여기서 기존에 방문 안된 부분 갈 수 있는지 확인 and 방문 안된 부분이라면 최소 비용으로 어떻게 갈 수 있는지
    for i in range(1, N + 1) : 
        
        # 만약 가지 않은 노드라면
        if visited[i] == False:
            # 기존 연결 유무 확인
            is_connect = False
            for nv in graph[v] : 
                if i == nv : 
                    is_connect = True
                    break
                
            # 만약 노드가 연결되어 있던 곳이라면 비용이 0이므로, 그 상태로 heap 에 추가
            if is_connect : 
                heapq.heappush(heap, (0.0, i))
            else : 
            # 연결이 안되어 있는 노드라면, 비용 계산 후 heap에 추가 해준다
                dist = get_dist(gods[v][0], gods[v][1], gods[i][0], gods[i][1])
                heapq.heappush(heap, (dist, i))        
            

print("{:.2f}".format(rs))