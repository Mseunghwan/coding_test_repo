import sys
from collections import deque
n = int(sys.stdin.readline())

deck = deque([])
for i in range(n):
    a = list(map(int, sys.stdin.readline().split()))
    if(a[0] == 1):
        deck.appendleft(a[1])
    elif(a[0] == 2):
        deck.append(a[1])
    elif(a[0] == 3):
        if(len(deck) != 0):
            print(deck.popleft())
        else:
            print(-1)
    elif(a[0] == 4):
        if(len(deck) != 0):
            print(deck.pop())
        else:
            print(-1)
    elif(a[0] == 5):
        print(len(deck))
    elif(a[0] == 6):
        if(len(deck) == 0):
            print(1)
        else:
            print(0)
    elif(a[0] == 7):
        if(len(deck) != 0):
            print(deck[0])
        else:
            print(-1)
    elif(a[0] == 8):
        if(len(deck) != 0):
            print(deck[-1])
        else:
            print(-1)
