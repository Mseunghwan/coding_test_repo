import sys

input = sys.stdin.readline

L, C = map(int, input().split())

lst = input().split()
lst.sort()
rs = []

def dfs(sentence, index) : 
    if len(sentence) == L :
        # 모음 cnt
        cnt_first = 0
        cnt_second = 0
        for i in sentence : 
            if i == 'a' or i == 'e' or i == 'i' or i == 'o' or i == 'u' :
                cnt_first += 1
            else : 
                cnt_second += 1
        if cnt_first >= 1 and cnt_second >= 2 :
            rs.append(sentence)
        return

    for i in range(index, C) : 
        dfs(sentence + lst[i], i + 1)


dfs("", 0)

for i in rs : 
    print(i)