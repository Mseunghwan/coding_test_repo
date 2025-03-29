import sys

input = sys.stdin.readline

result = []
def map_cutting(y, x, size):
    what = maps[y][x]
    for i in range(y, y + size):
        for j in range(x, x + size):
            if what != maps[i][j]:
                # 2사 분면(왼쪽 상단)
                map_cutting(y, x, size // 2)
                # 3사 분면(왼쪽 하단)
                map_cutting(y + (size // 2), x, size // 2)
                # 1사 분면(오른쪽 상단)
                map_cutting(y, x + (size // 2), size // 2)
                # 4사 분면(오른쪽 하단)
                map_cutting(y + (size // 2), x  + (size // 2), size // 2)
                return
            
    if what == 0:
        result.append(0)
    else:
        result.append(1)


n = int(input())

maps = []
for i in range(n):
    maps.append(list(map(int, input().split())))

map_cutting(0, 0, n)

print(result.count(0))
print(result.count(1))