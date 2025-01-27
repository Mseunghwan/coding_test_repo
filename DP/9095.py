import sys

input = sys.stdin.readline
t = int(input())


for i in range(t):
    n = int(input())

    rs = [0] * 11
    rs[0] = 0
    rs[1] = 1
    rs[2] = 2
    rs[3] = 4 
    for j in range(4, n+1):
        rs[j] = rs[j-1] + rs[j - 2] + rs[j - 3]
    print(rs[n])


