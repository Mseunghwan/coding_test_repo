import sys

input = sys.stdin.readline

N = int(input())

lst = list(map(int, input().split()))

lst.sort()

sum = 0
for i in range(len(lst)):
    if i > 0:
        lst[i] = lst[i] + lst[i - 1]
    
for i in range(len(lst)):
    sum += lst[i]

print(sum)