import sys

input = sys.stdin.readline

N = int(input())

lst = list(map(int, input().split()))

good_cnt = 0
lst.sort()
# 투 포인터로 접근
# 왼쪽 끝, 오른 쪽 끝에서 값이 작으면 왼쪽 늘리고, 반대면 오른쪽 줄여나가면서
# 만약 되는 경우라면 cnt 올리고 다음 수 보기
for i in range(N) :
    left = 0
    right = N - 1
    while(left < right) :
        if left == i :
            left += 1
            continue
        if right == i :
            right -= 1
            continue

        val = lst[left] + lst[right]

        # 지금 꺼 보다 크면
        if val < lst[i] :
            left += 1

        # 지금 꺼 보다 작으면
        if val > lst[i] :
            right -= 1

        # 동일하면 cnt += 1 후 탈출
        if val == lst[i] :
            good_cnt += 1
            break

print(good_cnt)
