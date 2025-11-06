import collections
import sys

input = sys.stdin.readline

n, m = map(int, input().split())
dict = collections.defaultdict(lambda : 0)

for i in range(n):
    str = input().rstrip()
    if len(str) >= m:
        if dict.get(str):
            dict[str][0] += 1
        else:
            dict[str] = [1, len(str), str]

result = sorted(dict.items(), key= lambda x: (-x[1][0], -x[1][1], x[1][2]))
for i in range(len(result)):
    print(result[i][0])
"""
x[0]은 키,
x[1]은 키가 갖는 value(list)
각각 sort
"""
