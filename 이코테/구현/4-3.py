import sys

input = sys.stdin.readline

n = input()
y = int(n[1])
x = 0
if n[0] == 'a':
    x = 1
elif n[0] == 'b':
    x = 2
elif n[0] == 'c':
    x = 3
elif n[0] == 'd':
    x = 4
elif n[0] == 'e':
    x = 5
elif n[0] == 'f':
    x = 6
elif n[0] == 'g':
    x = 7
elif n[0] == 'h':
    x = 8

night_steps = [(-2, -1), (-2, 1), (2, -1), (2, 1), (1, 2), (-1, 2), (1, -2), (-1, -2)]

cnt = 0
for a, b in night_steps:
    if 1 <= (x + a) <= 8 and 1 <= (y + b) <= 8:
        cnt += 1

print(cnt)