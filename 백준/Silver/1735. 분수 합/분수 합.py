a, b = map(int, input().split())
c, d = map(int, input().split())

up = (a * d) + (b * c)
down = b * d

def bcd(a, b):
    r = a % b
    if(r == 0):
        return b
    else :
        return bcd(b, r)
    
val = bcd(up, down)
if(val == 1):
    print(up, down)
else:
    print(int(up / val), int(down/ val))
