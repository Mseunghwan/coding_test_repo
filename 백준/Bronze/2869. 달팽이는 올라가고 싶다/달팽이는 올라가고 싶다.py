a, b, v = input().split()
a = int(a)
b = int(b)
v = int(v)

answer = (v-b) / (a-b)
if(answer == int(answer)):
    print(int(answer))
else:
    print(int(answer) + 1)