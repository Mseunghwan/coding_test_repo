import sys

input = sys.stdin.readline

n = list(map(int, input().rstrip()))
left = n[:len(n) // 2]
right = n[len(n) // 2:]
if sum(left) == sum(right):
    print("LUCKY")
else:
    print("READY")

