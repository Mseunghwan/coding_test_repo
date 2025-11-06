import sys
input = sys.stdin.readline

N = int(input())
vals = sorted([int(input()) for _ in range(N)])  # 오름차순 정렬

sum_vals = set()
for i in range(N):
    for j in range(i, N):
        sum_vals.add(vals[i] + vals[j])  # 두 수의 합을 저장

# 가장 큰 값부터 탐색하며 찾기
for k in range(N - 1, -1, -1):  # 가장 큰 값부터 탐색
    for i in range(k):
        if vals[k] - vals[i] in sum_vals:  # (현재 값 - 특정 값)이 존재하는지 확인
            print(vals[k])
            exit()
