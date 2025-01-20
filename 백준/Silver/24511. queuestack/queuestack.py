from collections import deque
import sys

n = int(sys.stdin.readline())
A = list(map(int, sys.stdin.readline().split()))
B = list(map(int, sys.stdin.readline().split()))
m = int(sys.stdin.readline())
C = list(map(int, sys.stdin.readline().split()))

queue = deque([])
a = 0
for i in range(n):
    if(A[i] == 0):
        queue.append(B[i])

for i in range(m):
    queue.appendleft(C[i])
    print(queue.pop(), end=' ')
        