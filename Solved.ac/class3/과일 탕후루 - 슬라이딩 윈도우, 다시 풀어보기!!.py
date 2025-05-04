"""
import sys
from collections import deque

input = sys.stdin.readline

n = int(input())

fruits = input().split()
right_fruits = deque(fruits)
left_fruits = deque(fruits)

while(len(set(right_fruits)) > 2) :
    right_fruits.pop()

while(len(set(left_fruits)) > 2) :
    left_fruits.popleft()

print(max(len(right_fruits), len(left_fruits)))

위 시간초과! 슬라이딩 윈도우 활용해야
"""

import sys
from collections import defaultdict

input = sys.stdin.readline

n = int(input())

fruits = input().split()

# 종류 세기
counter = defaultdict(int)

left = 0
max_len = 0
# 슬라이딩 윈도우
for right in range(n):
    counter[fruits[right]] += 1

    if len(counter) > 2 :
        counter[fruits[left]] -= 1
        if counter[fruits[left]] == 0 :
            del counter[fruits[left]]
        left += 1
    
max_len = max(max_len, right - left + 1)

print(max_len)


