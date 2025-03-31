import sys

input = sys.stdin.readline

s = list(input().rstrip())
s.sort()

result = 0
string = ""
for i in s:
    if i.isalpha():
        string += i
    else:
        result += int(i)
print(f"{string}{result}")