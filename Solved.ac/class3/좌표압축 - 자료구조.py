import sys

input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))

arr2 = sorted(set(arr))

dict = {}
index = 0

for now in arr2 :
    dict[now] = index
    index += 1

for i in arr :
    print(dict[i], end = " ")
    