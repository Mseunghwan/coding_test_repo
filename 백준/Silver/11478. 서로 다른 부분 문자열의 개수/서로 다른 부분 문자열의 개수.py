n = str(input())
sett = set()
for i in range(len(n)):
    for j in range(i, len(n)):
        sett.add(n[i:j+1])
print(len(sett))