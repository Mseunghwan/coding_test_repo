import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

N, M = map(int, input().split())

video = list(map(int, input().split()))

# 시작을 video의 가장 큰 값으로
start = max(video)
# 끝을 video의 합으로(최대)
end = sum(video)

def search(st, en, rs) : 
    if st > en :
        return rs
    # 중간 값을 구하고
    mid = (st + en) // 2

    total = 0
    # 자른 비디오 카운트
    cnt = 1 
    for val in video : 
        if total + val > mid : 
            cnt += 1
            total = 0
        total += val

    # 만약 cnt가 M 보다 작거나 같으면
    if cnt <= M : 
        # 더 큰 거 찾아보고
        return search(st, mid - 1, mid)
    else : 
    # 만약 cnt가 M보다 크다면
        return search(mid + 1, en, rs)

result = search(start, end, 0)
print(result)


