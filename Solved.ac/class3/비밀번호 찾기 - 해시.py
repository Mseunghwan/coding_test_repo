import sys

input = sys.stdin.readline

n, m = map(int, input().split())

hash_dict = {}
for i in range(n):
    site, password = input().split()
    hash_dict[site] = password

for _ in range(m):
    find = input().strip()
    print(hash_dict[find])
# https://www.acmicpc.net/problem/17219