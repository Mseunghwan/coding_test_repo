a = str(input())
b = []

a = a.lower()
count = {}
for char in a:
    if char in count:
        count[char] += 1
    else:
        count[char] = 1
max = max(count.values())
most = []
for key, value in count.items():
    if(value == max):
        most.append(key)
if len(most) > 1:
    print("?")
else : 
    print(most[0].upper())
