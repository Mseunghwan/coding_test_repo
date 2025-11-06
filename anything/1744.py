import sys

input = sys.stdin.readline

N = int(input())

zero_cnt = 0
one_cnt = 0
pos = []
neg = []
for i in range(N) : 
    val = int(input())
    if val == 0 : 
        zero_cnt += 1
    elif val == 1 : 
        one_cnt += 1
    elif val > 1 : 
        pos.append(val)
    elif val < 0 : 
        neg.append(val)

rs = 0
# 1은 항상 더하기
rs += one_cnt

pos.sort()
# 양수 처리 --> 곱셈
while(len(pos) >= 2) : 
    val_1 = pos.pop()
    val_2 = pos.pop()
    rs += val_1 * val_2

while(pos) : 
    rs += pos.pop()

# 음수 처리 --> 곱셈
neg.sort(reverse=True)

while(len(neg) >= 2) : 
    val_1 = neg.pop()
    val_2 = neg.pop()
    rs += val_1 * val_2

while(neg) : 
    if zero_cnt > 0 :
        zero_cnt -= 1
        neg.pop()
    else : 
        val = neg.pop()
        rs += val
print(rs)
