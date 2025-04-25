"""
import sys

input = sys.stdin.readline

n, m = map(int, input().split())
trees = list(map(int, input().split()))


most_high = max(trees)

for i in range(most_high, -1, -1):
    get = 0
    for now in trees:
        if now > i:
            get += (now - i)

    if get >= m :
        break
print(i)

"""
# 위 사례는 시간초과, 이분탐색으로 풀어야



import sys

input = sys.stdin.readline

n, m = map(int, input().split())
trees = list(map(int, input().split()))

lower = 0
upper = max(trees)

answer = 0

while lower <= upper :
    mid = int((lower + upper) / 2)

    total = 0
    for tree in trees :
        if tree > mid:
            total += tree - mid
    
    if total >= m :
        # 현재로도 조건 만족하면
        answer = mid
        # 혹시 톱을 더 높일 수 있는지 mid + 1로 하한을 잡고
        lower = mid + 1
    else :
        # 조건 만족 못하니 상한을 조금 더 아래로 잡고
        upper = mid - 1
print(answer)



