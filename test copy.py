import sys

input = sys.stdin.readline

# N 일동안 정확히 M 번만 통장에서 돈을 빼기로
N, M = map(int ,input().split())

bal = []
for i in range(N) : 
    bal.append(int(input()))

def search(st, en, rs) : 

    if st > en :
        return rs
    mid = (st + en) // 2

    mid_total = mid

    cnt = 1

    for i in bal : 
        if i > mid_total : 
            cnt += 1
            mid_total = mid
        mid_total -= i

    if cnt > M :
        return search(mid + 1, en, rs)
    else :
        return search(st, mid - 1, mid)


start = max(bal)
end = sum(bal)

result = search(start, end, 0)
print(result)
