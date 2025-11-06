import sys
import heapq

input = sys.stdin.readline

V, E = map(int, input().split())

maps = [[] for _ in range(V + 1)]
check = [False] * (V + 1)
for i in range(E) : 
    st, en, w = map(int, input().split())
    maps[st].append((w, en))
    maps[en].append((w, st))

rs = 0
heap = [[0, 1]]

while heap : 
    w, node = heapq.heappop(heap)

    if check[node] == False : 
        check[node] = True
        rs += w
    
        for next_one in maps[node] : 
            if check[next_one[1]] == False : 
                heapq.heappush(heap, next_one)
print(rs)