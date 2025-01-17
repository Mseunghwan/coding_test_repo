import sys

def is_balanced(string):
    stack = []
    for char in string:
        if char == '(' or char == '[':
            stack.append(char)
        elif char == ')':
            if stack and stack[-1] == '(':
                stack.pop()
            else:
                return False
        elif char == ']':
            if stack and stack[-1] == '[':
                stack.pop()
            else:
                return False
    return not stack  # 스택이 비어 있으면 균형 잡힌 문자열

def main():
    input = sys.stdin.read().splitlines()  # 여러 줄 입력 받기
    for line in input:
        if line == ".":
            break  # 종료 조건
        if is_balanced(line[:-1]):  # 온점을 제외한 문자열 확인
            print("yes")
        else:
            print("no")

if __name__ == "__main__":
    main()
