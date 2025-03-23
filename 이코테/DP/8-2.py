# 피보나치 수열 --> 1, 1, 2, 3, 5, 8, 13, 21 ,,,
# 메모이제이션 위한
# 재귀를 통한 방식? Top-Down 방식 --> 큰 문제를 해결하기 위해 작은 문제를 호출함

d = [0] * 100

def fibo(x):
    print('f(' + str(x) + ')', end = ' ')
    if x == 1 or x == 2 :
        return 1

    if d[x] != 0:
        return d[x]
    
    d[x] = fibo(x-1) + fibo(x-2)
    return d[x]


print(fibo(99))

