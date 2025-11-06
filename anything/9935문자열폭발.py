import sys

input = sys.stdin.readline

sentence = list(input().rstrip())
boom = list(input().rstrip())
boom_length = len(boom)
stack = []

for char in sentence :
    stack.append(char)
    # stack 길이가 비교 가능할 만큼 된다면
    if len(stack) >= boom_length : 
        if stack[-boom_length : ] == boom : 
            for i in range(boom_length) : 
                stack.pop()

    

if len(stack) > 0 : 
    print(''.join(stack))
else : 
    print("FRULA")