import sys

input = sys.stdin.readline

n, m = map(int, input().split())

poke_num = {}
poke_name = {}
for i in range(n):
    p = input().strip("\n")
    poke_num[p] = i
    poke_name[i] = p

for _ in range(m):
    call = input().strip("\n")
    if call.isdigit() :
        print(poke_name[int(call) - 1])
    else :
        print(poke_num[call] + 1)