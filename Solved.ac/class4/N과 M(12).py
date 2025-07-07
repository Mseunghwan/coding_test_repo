import sys
from itertools import permutations, combinations

input = sys.stdin.readline

n, m = map(int, input().split())
lst = list(map(int, input().split()))

print(list(permutations(lst, m)))
print(list(combinations(lst, m)))
