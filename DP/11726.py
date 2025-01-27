"""
1. 아이디어
 - 점화식 : An = An-1 + An-2
 - n값 구하기 위해, for 문으로 3부터 n까지의 값을 구해주기
 - 이전값과 그 이전값을 더해서 10007로 나눠 저장
2. 시간복잡도
 - O(N)
3. 자료구조
 - DP값 저장하는 (경우의 수) 배열 : int[]
 - 최대값 : 10007보다 작음 > INT
"""

import sys
input = sys.stdin.readline

n = int(input())
rs = [0, 1, 2]

for i in range(3, n + 1):
    rs.append(rs[i-1] + rs[i-2] % 10007)


print(rs.pop())
