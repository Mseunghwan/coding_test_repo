import sys

input = sys.stdin.readline

n = int(input())
lst = list(map(int, input().split()))
lst.sort()

target = 1
for x in lst :
    if target < x:
        break
    target += x


print(target)