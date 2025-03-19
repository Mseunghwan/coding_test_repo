import sys
from itertools import product

input = sys.stdin.readline

N, M = map(int, input().split())

def backtrack(start, path):
    if(len(path) == M):
        print(* path)
        return 
    for i in range(start, N + 1):
        backtrack(i, path + [i])

backtrack(1, [])

"""
backtrack(1, [])  # 처음 시작 (1부터 시작, 아직 숫자 없음)
    ├─ backtrack(1, [1])  # 1을 선택!
        ├─ backtrack(1, [1, 1])  # 1을 또 선택! (출력: 1 1)
        ├─ backtrack(2, [1, 2])  # 2 선택 (출력: 1 2)
        ├─ backtrack(3, [1, 3])  # 3 선택 (출력: 1 3)
    ├─ backtrack(2, [2])  # 2를 선택!
        ├─ backtrack(2, [2, 2])  # 2 선택 (출력: 2 2)
        ├─ backtrack(3, [2, 3])  # 3 선택 (출력: 2 3)
    ├─ backtrack(3, [3])  # 3을 선택!
        ├─ backtrack(3, [3, 3])  # 3 선택 (출력: 3 3)

        """