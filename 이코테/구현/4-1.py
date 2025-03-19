import sys

input = sys.stdin.readline

n = int(input())

go = []
go = input().split()

y, x = 1, 1
for i in go:
    if i == 'R' : 
        if 1 <= x <= 4:
            x += 1
    elif i == 'L' : 
        if 2 <= x <= 5:
            x -= 1
    elif i == 'U' : 

        if 2 <= y <= 5:
            y -= 1
    elif i == 'D' :
        if 1 <= y <= 4:
            y += 1

print(y, x)