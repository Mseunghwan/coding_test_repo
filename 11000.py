import sys
import heapq

input = sys.stdin.readline

N = int(input())

times = []
for i in range(N) : 
    st, en = map(int, input().split())
    times.append((st, en))

times.sort()

heap = []

for i in range(len(times)) : 
    st = times[i][0]
    en = times[i][1]
    
    # 재사용 가능 여부
    if heap and st >= heap[0] : 
        # 재사용 가능, 
        heapq.heappop(heap)
        heapq.heappush(heap, en)
    else : 
        # 재사용 불가,
        # 강의실 추가
        heapq.heappush(heap, en)

print(len(heap))