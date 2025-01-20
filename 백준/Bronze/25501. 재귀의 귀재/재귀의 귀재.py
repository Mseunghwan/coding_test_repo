import sys

def recursion(s, l, r, cnt):
    
    cnt += 1
    if l >= r :
        return 1, cnt
    elif s[l] != s[r] :

        return 0, cnt
    else : 
        return recursion(s, l+1, r-1, cnt)

def isPalindrome(s, cnt):
    return recursion(s, 0, len(s) - 2, cnt)

n = int(sys.stdin.readline())

for i in range(n):
    cnt = 0
    S = sys.stdin.readline()
    recur, count = isPalindrome(S, cnt)
    print(recur, count)
    
