import sys

input = sys.stdin.readline

nums = list(map(int, input().rstrip()))
multiple = []

for i in range(len(nums)):
    if i > 0:
        mul = nums[i] * nums[i - 1]
        add = nums[i] + nums[i - 1]
        if mul > add :
            nums[i] = mul
        else : 
            nums[i] = add
print(nums[-1])



