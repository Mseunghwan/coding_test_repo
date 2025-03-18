import sys
"""
입력값 : 
15 14
00000111100000
11111101111110
11011101101110
11011101100000
11011111111111
11011111111100
11000000011111
01111111111111
00000000011111
01111111111000
00011111111000
00000001111000
11111111110011
11100011111111
11100011111111
"""

cnt = 0

def dfs(y, x):
    if y < 0 or y >= N or x < 0 or x >= M:
        return False
    
    # 재귀로 호출해서 1을 다 채운다
    if maps[y][x] == False:
        maps[y][x] = True
        dfs(y+1, x)
        dfs(y-1, x)
        dfs(y, x+1)
        dfs(y, x-1)
        return True
    return False
        

    

input = sys.stdin.readline

N, M = map(int, input().split())

maps = []
for i in range(N):
    maps.append(list(map(int, list(input().rstrip()))))

count = 0

for i in range(N):
    for j in range(M):
        if dfs(i, j) == True:
            count += 1
print(count)

