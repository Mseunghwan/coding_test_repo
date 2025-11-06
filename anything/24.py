import sys
from itertools import permutations

input = sys.stdin.readline

n, m = map(int, input().split())

lst = []
lst.append(list(map(int, input().split())))
permu_lst = []
permu_lst = list(permutations(lst[0], m))
permu_lst.sort()
for i in permu_lst:
    for j in i:
        print(j, end = " ")
    print()