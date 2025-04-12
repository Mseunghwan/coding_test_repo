import sys

input = sys.stdin.readline

N, M = map(int, input().split())

lst = list(map(int, input().split()))

for i in range(len(lst)):
    if i > 0:
        lst[i] = lst[i] + lst[i-1]

for i in range(M):
    i, j = map(int, input().split())
    if i == 1:
        print(lst[j - 1])
    else:
        print(lst[j - 1] - lst[i - 2])