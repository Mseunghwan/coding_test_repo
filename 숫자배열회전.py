import sys

input = sys.stdin.readline


t = int(input())

for i in range(t):
    n = int(input())
    
    lst = []
    for i in range(n):
        
        lst.append(list(map(int, input().split())))

    print(lst)