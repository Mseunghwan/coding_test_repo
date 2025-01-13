row, col = 9, 9
val = []
for i in range(row):
    val.append(list(map(int, input().split())))
max_val = val[0][0]
num_row = 0
num_col = 0


for i in range(row):
    for j in range(col):
        if(max_val <= val[i][j]):
            max_val = val[i][j]
            num_row = i + 1
            num_col = j + 1

print(max_val)
print(num_row, num_col)
