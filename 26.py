"""
import sys

input = sys.stdin.readline


첫 시도 : 무식하게 for문
n, m = map(int, input().split())
maps = []
for i in range(n):
    maps.append(list(map(int, input().split())))

search_for = []
for i in range(m):
    search_for.append(list(map(int, input().split())))

result = []
for i in range(len(search_for)):
    sum = 0
    nowOne = search_for[i]
    for j in range(len(maps)):
        for k in range(len(maps[0])):
            if nowOne[0] - 1 <= j <= nowOne[2] - 1 and nowOne[1] - 1 <= k <= nowOne[3] - 1 :
                sum += maps[j][k]
    result.append(sum)
for i in result:
    print(i)
"""
"""
두 번째 시도,
점화식을 잘못 짬 --> 풀 수는 있지만 오류가 많고, 문제의 의도와 다름
import sys

input = sys.stdin.readline

n, m = map(int, input().split())
maps = []
for i in range(n):
    maps.append(list(map(int, input().split())))

search_for = []
for i in range(m):
    search_for.append(list(map(int, input().split())))

for i in range(len(maps)):
    for j in range(len(maps[0])):
        if j > 0 : 
            maps[i][j] = maps[i][j] + maps[i][j - 1]
        elif j == 0 and i > 0:
            maps[i][j] = maps[i][j] + maps[i-1][-1]

for y1, x1, y2, x2 in search_for:
    
    if y1 == 1 and x1 == 1:
        print(maps[y2 - 1][x2 - 1])
        continue
    elif y1 == y2 and x1 == x2 : 
        if x2 - 1 > 0 :
            print(maps[y2 - 1][x2 - 1] - maps[y2 - 1][x2 - 2])
            continue
        elif x2 - 1 == 0 and y2 - 1> 0:
            print(maps[y2 - 1][x2 - 1] - maps[y2 - 2][-1])
            continue
    else : 
        print(maps[y2 - 1][x2 - 1] - maps[y1 - 1][x1 - 1])
        continue
"""

"""
답,
아직도 스스로 풀라하면 쉽지 않다...,
"""
import sys

input = sys.stdin.readline

n, m = map(int, input().split())
maps = []
for i in range(n):
    maps.append(list(map(int, input().split())))

search_for = []
for i in range(m):
    search_for.append(list(map(int, input().split())))

for i in range(n):
    for j in range(n):
        if i > 0:
            maps[i][j] += maps[i-1][j]
        if j > 0:
            maps[i][j] += maps[i][j - 1]
        if i > 0 and j > 0:
            maps[i][j] -= maps[i - 1][j - 1]

for y1, x1, y2, x2 in search_for:
    result = maps[y2-1][x2-1]
    if y1 > 1:
        result -= maps[y1-2][x2-1]
    if x1 > 1:
        result -= maps[y2-1][x1-2]
    if x1 > 1 and y1 > 1 :
        result += maps[y1-2][x1-2]
    print(result)