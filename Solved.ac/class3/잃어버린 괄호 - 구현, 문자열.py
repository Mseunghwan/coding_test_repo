import sys

input = sys.stdin.readline

line = input().strip()

result = 0 

list = list(line.split('-'))

result += sum(map(int, list[0].split('+')))

for i in range(1, len(list)):
    result -= sum(map(int, list[i].split('+')))

print(result)




