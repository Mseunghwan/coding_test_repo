got = str(input()).split()
should_get = [1, 1, 2, 2, 2, 8]

for i in range(len(should_get)):
    print(should_get[i] - int(got[i]), end=' ')