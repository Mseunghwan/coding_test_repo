import sys

input = sys.stdin.readline 


n, m = map(int, input().split())


inputs = [] 
for i in range(m):
    inputs.append(list(map(int, input().split())))

where = []
for i in range(n):
    where.append(i + 1)

for i in range(m):
    # 넣어주기(가짜로)
    if inputs[i][0] == 0:
        for j in range(n):
            if where[j] == inputs[i][2]:
                where[j] = inputs[i][1]
    # 확인
    elif inputs[i][0] == 1:
        if where[inputs[i][2] - 1] == where[inputs[i][1] - 1]:
            print("YES")
        else:
            print("NO")

