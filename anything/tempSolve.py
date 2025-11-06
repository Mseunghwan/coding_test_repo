"""
1. 아이디어
- 투포인터를 활용
- tor문으로, 처음에 K개 값을 저장
- 다음인덱스 더해주고, 이전 인덱스 빼줌
- 이때마다 최대값을 갱신

2. 시간복잡도
- O(N) = 1e5 > 가능

3. 자료구조
- 각 숫자들 N개 저장 배열 : int[]
- 숫자들 최대 100 > INT 가능
- K개의 값을 저장 변수 : int
- 최대 : K * 100 = 1e5* 100= 1e7 > 지자능
- 최대값 : int
"""
import sys

input = sys.stdin.readline

n, k = map(int, input().split())

numbers = list(map(int, input().split()))

sum = 0
# 초기 K까지의 값 세팅
for i in range(k) : 
    sum += numbers[i]

maxVal = sum

for i in range(k, n) : 
    # 다음 인덱스 더해주고,
    sum += numbers[i]
    # 이전 인덱스는 빼주기
    sum -= numbers[i - k]
    if sum > maxVal :
        maxVal = sum

print(maxVal)
    
