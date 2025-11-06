import sys


input = sys.stdin.readline

n, r, c = map(int, input().split())

# r행 c열 몇 번째로 방문하는가?

def dimms_cnt(n, r, c):
    if n == 0 :
        return 0 

    half = 2 ** (n - 1)
    size = half * half

    if r < half and c < half:
        return dimms_cnt(n - 1, r, c)
    elif r < half and c >= half:
        return size + dimms_cnt(n - 1, r, c - half)
    elif r >= half and c < half:
        return 2 * size + dimms_cnt(n - 1, r - half, c)
    elif r >= half and c >= half: 
        return 3 * size + dimms_cnt(n - 1, r - half, c - half)

print(dimms_cnt(n, r, c))

