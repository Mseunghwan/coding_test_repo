row, col = map(int, input().split())

A = []
for i in range(row):
    val = map(int, input().split())
    A.append(list(val))

B = []
for i in range(row):
    val = map(int, input().split())
    B.append(list(val))

C = []
for i in range(row):
    line = []
    for j in range(col):
        line.append(A[i][j] + B[i][j])
    C.append(line)

for i in range(len(C)):
    for j in range(len(C[i])):
        print(C[i][j], end=" ")
    print("")