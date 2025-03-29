import sys

input = sys.stdin.readline

t = int(input())

for i in range(t):
    n = int(input())
    sticker = []
    sticker.append(list(map(int, input().split())))
    sticker.append(list(map(int, input().split())))
    
    print(sticker)
