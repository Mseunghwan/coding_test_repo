import sys


input = sys.stdin.readline

n = int(input())
for i in range(n):
    m = int(input())
    lst = list(map(int, input().split()))
    sum = 0
    max_val = 0
    for j in range(len(lst) - 1, -1, -1):
        if j == len(lst) - 1:
            max_val = lst[j]
        if lst[j] > max_val:
            max_val = lst[j]
        elif lst[j] < max_val:
            sum += max_val - lst[j]
    print(sum)
