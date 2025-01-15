n = int(input())
lst = [[0] * 2 for _ in range(n)]
dictionary = {}
out = []
for i in range(n):
    a, b =input().split()
    if(b == "enter"):
        dictionary[a] = b
    else:
        dictionary[a] = b
d1 = sorted(dictionary.items(), reverse=True)
for i in range(len(d1)):
    if(d1[i][1] == "enter"):
        print(d1[i][0])