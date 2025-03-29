import sys

input = sys.stdin.readline

# 회의의 최대 개수

n = int(input())

time = []
for i in range(n):
    time.append(list(map(int, input().split())))

# 회의 끝나는 시간 오름차 순으로
time.sort(key = lambda x : (x[1], x[0]))
cnt = 0
end_time = -1
# 반례?
# [2 4] [3 5] [7 7] [6 7] [5 7] 라면
# 7 7을 제대로 처리하지 못하는 --> 7 7 도 가능하지만 5 7 뒤이기에 그냥 넘어감
# 그렇기에 sort에 
for t in time:
    if t[0] >= end_time :
        cnt += 1
        end_time = t[1]
print(cnt)