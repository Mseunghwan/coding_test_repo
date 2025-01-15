n = int(input())
count = 0
i = 666
while(count != n):
    if(str(i).count("666")>=1):
        count += 1
    if(count == n):
        print(i)
    i+=1
