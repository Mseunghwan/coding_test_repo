import sys
from collections import deque

input = sys.stdin.readline

t = int(input())

for i in range(t):
    p = input().strip()
    n = int(input())
    lst = input().strip()

    if n != 0 : 
        lst = deque(list(map(int, lst[1 : -1].split(','))))
    else :
        lst = deque()

    is_reversed = False
    error_flag = False

    for i in p :
        if i == 'R' : 
            is_reversed = not is_reversed
        elif i == 'D' : 
            if len(lst) > 0:
                if is_reversed == False :
                    lst.popleft()
                else : 
                    lst.pop()
            else : 
                error_flag = True
                break

    if error_flag : 
        print("error")
    else : 
        if is_reversed == True : 
            lst.reverse()
        print('[' + ','.join(map(str, lst)) + ']')