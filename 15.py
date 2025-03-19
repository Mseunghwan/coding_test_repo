import sys

input = sys.stdin.readline

n = int(input())

lst = list(map(int, input().split()))
human = [0] * n

result = []
for i in range(n):
    cnt = 0
    for j in range(len(human)):
        if human[j] == 0:
            if cnt == lst[i]:
                human[j] = i + 1
            cnt += 1

for i in human:
    print(i, end = " ")