"""
기존 풀이
시간복잡도 : O(N^2)
import sys
from collections import deque

N, K = map(int, input().split())
lst = []
lst = list(map(int, input().split()))

dict = {}
for i in range(N):
    dict[lst[i]] = 0

queue = deque([0])
max = 0
while queue:
    now = queue.popleft()
    if now == N : 
        break
    leng = 0
    for i in range(now, N):
    
        dict[lst[i]] += 1
        if(dict[lst[i]] == K + 1):
            if(leng > max):
                max = leng
            break
        if(i == N - 1):
            if(leng > max):
                max = leng
            break
        leng += 1
    queue.append(now + 1)
print(max)

"""

import sys

N, M = map(int, input().split())
arr = list(map(int, input().split()))


sequence = [0] * (max(arr) + 1) # 1. arr의 최대 값만큼의 길이를 가진 배열 생성
left, right = 0, 0 # 투포인터 index
result = 0 # 최대값을 저장할 변수

# 2. N만큼 Loop
while right < N:
    
    # 3. 배열에서 해당 idx값이 M보다 작으면 더해준다.
    if sequence[arr[right]] < M:
        sequence[arr[right]] += 1
        right += 1
    # 4. M 보다 크면 left를 전진해주고 해당 값을 1 빼준다.
    else:
        sequence[arr[left]] -= 1
        left += 1
    
    # 5. result에 수열의 길이(right-left)를 할당한다.
    """
    여기서 print(result, right, left, right - left) 하면 더 자세히 볼 수 있는데,
    0 1 0 1
    1 2 0 2
    2 3 0 3
    3 4 0 4
    4 5 0 5
    5 6 0 6
    6 7 0 7
    7 7 1 6
    7 7 2 5
    7 7 3 4
    7 8 3 5
    7 9 3 6
    이렇게 된다,
    """
    
    result = max(result, right - left)
    
print(result)