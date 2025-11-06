import sys

input = sys.stdin.readline

N, M = map(int, input().split())

numbers = list(map(int, input().split()))

numbers.sort()

def backtracking(nums, M) : 
    if len(nums) == M : 
        for i in range(M) : 
            print(nums[i], end = " ")
        print()
        return
    for i in range(N) : 
        nums.append(numbers[i])
        backtracking(nums, M)
        nums.pop()

for i in range(N) : 
    backtracking([numbers[i]], M)
