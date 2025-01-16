# 유클리드 호제법
def gcd(a, b):
    r = a % b
    if(r == 0):
        return b
    else:
        return gcd(b, r)
    

a, b = map(int, input().split())

print(int((a * b) / gcd(a, b)))