import sys
import heapq

input = sys.stdin.readline

N = int(input())

heap = []
for i in range(N) : 
    val = int(input())

    if val == 0 : 
        if len(heap) == 0 : 
            print(0)
        else : 
            pop = heapq.heappop(heap)
            print(pop[1])
    else : 
        heapq.heappush(heap, [abs(val), val])