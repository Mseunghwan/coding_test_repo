import sys

input = sys.stdin.readline

nums = list(map(int, input().rstrip()))

cnt_0 = 0
cnt_1 = 0

for i in range(0, len(nums)):
    if i == 0:
        if nums[i] == 0 : cnt_0 += 1
        elif nums[i] == 1 :  cnt_1 += 1
    else:
        if nums[i] != nums[i - 1]:
            if nums[i] == 0:
                cnt_0 += 1
            else:
                cnt_1 += 1

print(min(cnt_0, cnt_1))
