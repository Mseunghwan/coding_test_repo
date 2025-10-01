import sys
from pprint import pprint

input = sys.stdin.readline

maps = []
zeros = []
for i in range(9) : 
    val = list(map(int, input().split()))
    maps.append(val) 
    for j in range(9) : 
        if val[j] == 0 : 
            zeros.append([i, j])            

def check(y, x, num) : 
    for i in range(9) : 
        if maps[y][i] == num : 
            return False

    for i in range(9) : 
        if maps[i][x] == num : 
            return False
        
    start_x = (x // 3) * 3
    start_y = (y // 3) * 3
    for i in range(start_y, start_y + 3) : 
        for j in range(start_x, start_x + 3) : 
            if maps[i][j] == num : 
                return False
    return True
def back_tracking(index) : 
    if index == len(zeros):
        for i in range(9):
            for j in range(9) : 
                print(maps[i][j], end = " ")
            print()
        sys.exit(0)
    
    y, x = zeros[index]
    for num in range(1, 10) : 
        if check(y, x, num) :
            maps[y][x] = num
            back_tracking(index + 1)
            maps[y][x] = 0
back_tracking(0)
