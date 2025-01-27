# gpt 도움을 빌림!!**
import sys
sys.setrecursionlimit(10000)

R, C = map(int, sys.stdin.readline().split())

ground = [list(sys.stdin.readline().strip()) for _ in range(R)]

dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

# 방문 여부를 기록할 배열 (알파벳 A~Z는 26개이므로 크기는 26으로 충분)
visited = [False] * 26

max_cnt = 1

def dfs(y, x, cnt):
    global max_cnt
    max_cnt = max(max_cnt, cnt)
    
    for k in range(4):
        nx = x + dx[k]
        ny = y + dy[k]
        
        if 0 <= ny < R and 0 <= nx < C:
            # 현재 문자 인덱스 구하기
            char_idx = ord(ground[ny][nx]) - ord('A')
            if not visited[char_idx]:
                visited[char_idx] = True
                dfs(ny, nx, cnt + 1)
                visited[char_idx] = False

# 처음 시작 문자는 이미 방문 처리
visited[ord(ground[0][0]) - ord('A')] = True
dfs(0, 0, 1)

print(max_cnt)
