import sys
n = int(sys.stdin.readline())
lst = []
for i in range(n):
    a = sys.stdin.readline().split()
    if(a[0] == "1"):
        lst.append(a[1])
    elif(a[0] == "2"):
        if(len(lst) >= 1):
            print(lst.pop())
        else:
            print('-1')
    elif(a[0] == "3"):
        print(len(lst))
    elif(a[0] == "4"):
        if(len(lst) == 0):
                print(1)
        else:
            print('0')
    elif(a[0] == "5"):
        if(len(lst) >= 1):
            print(lst[-1])
        else:
            print('-1')


