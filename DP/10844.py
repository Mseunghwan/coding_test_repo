"""
점화식 : An = An-1 + (8*(i-1))
"""

import sys

input = sys.stdin.readline

n = int(input())

rs = [0] * (n+1)
rs.insert(1, 9)
rs.insert(2, 17)

for i in range(2, n+1):
    rs[i] = rs[i-1] + 8 * (i-1)

print(rs[n])