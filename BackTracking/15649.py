"""
1. 아이디어
 - 백트래킹 재귀함수 안에서, for 돌면서 숫자 선택(이떄 방문여부 확인)
 - 재귀함수에서 M개를 선택할 경우 print

2. 시간복잡도
 - N! --> 2억보다 낮아야 하니 10까지 가능, 여기선 8까지므로 가능

3. 자료구조
 - 결과값 저장 int[]
 - 방문여부 체크 bool[]


 과정 설명
첫 번째 재귀 호출:

rs = [], chk = [False, False, False, False, False]

for 루프에서 i = 1 선택:

rs = [1], chk = [False, True, False, False, False]

재귀 호출: recur(1)

두 번째 재귀 호출:

rs = [1], chk = [False, True, False, False, False]

for 루프에서 i = 2 선택:

rs = [1, 2], chk = [False, True, True, False, False]

num == m이므로 1 2 출력.

rs = [1], chk = [False, True, False, False, False]로 복원.

for 루프에서 i = 3 선택:

rs = [1, 3], chk = [False, True, False, True, False]

num == m이므로 1 3 출력.

rs = [1], chk = [False, True, False, False, False]로 복원.

for 루프에서 i = 4 선택:

rs = [1, 4], chk = [False, True, False, False, True]

num == m이므로 1 4 출력.

rs = [1], chk = [False, True, False, False, False]로 복원.

첫 번째 재귀 호출로 복귀:

rs = [], chk = [False, False, False, False, False]로 복원.

for 루프에서 i = 2 선택:

rs = [2], chk = [False, False, True, False, False]

재귀 호출: recur(1)

위와 같은 과정 반복:

모든 경우의 수를 탐색하며 결과를 출력합니다.

"""

import sys
input = sys.stdin.readline

n, m = map(int, input().split())
rs = []
chk = [False] * (n+1)


def recur(num):
    if num == m:
        print(' '.join(map(str, rs)))
        return 
    for i in range(1, n+1):
        if chk[i] == False:
            chk[i] = True
            rs.append(i)
            recur(num + 1)
            chk[i] = False # 다음 실행을 위해 True로 고정된 chk를 풀어주는
            rs.pop() # 다음 실행을 위해 rs 리스트를 비워주는

recur(0)


