import sys


input = sys.stdin.readline

n = int(input())
cnt = 0 
for h in range(n + 1):
    for i in range(60):
        for j in range(60):
            if '3' in str(h) + str(i) + str(j):
                cnt += 1

print(cnt)