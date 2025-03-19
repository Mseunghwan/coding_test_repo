import sys


input = sys.stdin.readline

N = int(input())
M = int(input())
S = input()


P_length = 3 + (2 * (N - 1))
val = 0
i = 0
while i < M:
    if(S[i] == "I"):
        cnt = 0
        while i + 2 < M and S[i + 1] == "O" and S[i + 2] == "I":
            cnt += 1
            i += 2
            if cnt >= N:
                val += 1
        i += 1
    else : 
        i += 1
print(val)


