import sys

input = sys.stdin.readline

T = int(input())
d = [[0, 0] for _ in range(41)]
d[0] = [1, 0]
d[1] = [0, 1]

for i in range(2, 41):
    d[i][0] = d[i-1][0] + d[i-2][0]
    d[i][1] = d[i-1][1] + d[i-2][1]
    
for i in range(T):
    n = int(input())
    print(d[n][0], d[n][1])
    