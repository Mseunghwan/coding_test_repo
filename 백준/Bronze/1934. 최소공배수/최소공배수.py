n = int(input())



def gcd(a, b):
    r = a % b
    if(r == 0):
        return b
    else:
        return gcd(b, r)
    

for i in range(n):
    a, b = map(int, input().split())
    print(int((a * b) / gcd(a, b)))
