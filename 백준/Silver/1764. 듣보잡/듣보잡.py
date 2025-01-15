n, m = map(int, input().split())

set0 = set()
set1 = set()
for i in range(n):
    set0.add(input())
for i in range(m):
    set1.add(input())

result = sorted(set0 & set1)
print(f"{len(result)}\n" + '\n'.join(result))