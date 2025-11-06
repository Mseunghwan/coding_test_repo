import sys

input = sys.stdin.readline

N, M = map(int, input().split())

numbers = [i for i in range(1, N + 1)]

def backtracking(nums, M, visited) : 
    if len(nums) == M : 
        for i in range(M) : 
            print(nums[i], end=" ")
        print()
        return
    
    for i in range(N) : 
        nums.append(numbers[i])
        backtracking(nums, M, visited)
        nums.pop()
            


for i in range(N) : 
    visited = [False] * (N + 1)
    backtracking([numbers[i]], M, visited)