"""
dp 문제
Knapsack 
1. 짐을 쪼갤 수 있는 경우 - Greedy
2. 짐을 쪼갤 수 없는 경우 - DP


"""
import sys

input = sys.stdin.readline

n, k = map(int, input().split())

things = []
for i in range(n):
    things.append(list(map(int, input().split())))

things.sort(key = lambda x : (x[0], -x[1]))
print(things)