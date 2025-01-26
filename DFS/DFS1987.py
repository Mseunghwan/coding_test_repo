import sys
sys.setrecursionlimit(10000)  # 재귀 제한 늘리기
input = sys.stdin.readline

R, C = map(int, input().split())

ground = []
for i in range(R):
    ground.append(input().strip())

visit = set(ground[0][0])
cnt = 1
dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]
def dfs(y, x):
    global cnt
    cnt = max(cnt, len(visit))
    for k in range(4):
        nx = x + dx[k]
        ny = y + dy[k]
        if(0<=ny<R and 0<=nx<C and ground[ny][nx] not in visit):
            visit.add(ground[ny][nx])
            dfs(ny, nx)
            visit.remove(ground[ny][nx]) # 백트래킹 사용 ->  A - B - C 가 아니라 A - E - F  다양하게 가도록
                
dfs(0, 0)
print(cnt)
        