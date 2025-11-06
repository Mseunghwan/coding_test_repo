import sys
import heapq
# from collections import deque

input = sys.stdin.readline

T = int(input())

for i in range(T) : 
    k = int(input())

    minHeap = []
    maxHeap = []
    # id에서 flag가 True 라면 삭제된 값이라는 뜻
    flag = [False] * k 
    id = 0
    for j in range(k) : 
        command, val = input().split()

        if command == "I" : 
            # 우선 minHeap과 maxHeap 두 곳에 함께 넣어줌(동기화)
            heapq.heappush(minHeap, (int(val), id))
            heapq.heappush(maxHeap, ((int(val) * -1), id))
            id += 1
        elif command == "D" and val == '1' :
                 # D 1은 최댓값 삭제
                 # maxHeap에서 pop 해서 삭제해주기
            if len(maxHeap) > 0 : 
                rm_id = heapq.heappop(maxHeap)
                while(flag[rm_id[1]] == True and len(maxHeap) > 0): 
                    if len(maxHeap) > 0 :
                        rm_id = heapq.heappop(maxHeap)
                flag[rm_id[1]] = True
                

        elif command == "D" and val == '-1' : 
                # D -1은 최솟값 삭제
            if len(minHeap) > 0 : 
                rm_id = heapq.heappop(minHeap)
                while(flag[rm_id[1]] == True and len(minHeap) > 0): 
                    rm_id = heapq.heappop(minHeap)
                flag[rm_id[1]] = True
                

    # 출력 부분
    # True면 삭제된 값이므로 다음과 같이 조건식 세워 while
    while maxHeap and flag[maxHeap[0][1]] : 
        heapq.heappop(maxHeap)
    while minHeap and flag[minHeap[0][1]] : 
        heapq.heappop(minHeap)

    if len(maxHeap) == 0 or len(minHeap) == 0 :
        print("EMPTY")
    else : 
        print(-maxHeap[0][0], minHeap[0][0])
        