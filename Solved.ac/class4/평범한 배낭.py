import sys

input = sys.stdin.readline

n, k = map(int, input().split())

lst = []
for i in range(n) : 
    lst.append(list(map(int, input().split())))

lst.sort()
print(lst)