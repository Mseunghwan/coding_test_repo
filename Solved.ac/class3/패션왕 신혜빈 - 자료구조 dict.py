import sys

input = sys.stdin.readline

t = int(input())

for i in range(t):
    n = int(input())
    clothes = {}
    cnt = []
    for j in range(n):
        item, wear = input().split()
        if wear in clothes:
            clothes[wear].append(item)
        else : 
            clothes[wear] = [item]


    result = 1
    for wear_list in clothes.values():
        result *= (len(wear_list) + 1) # 입는 경우, 안입는 경우
    print(result - 1) # 아예 안입는것 제외

# 경우의 수 구하기 문제이다. dict 사용법 잘 알아야 할 듯