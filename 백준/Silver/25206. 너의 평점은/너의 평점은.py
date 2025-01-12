line = 20
score = 0
num = 0
grades = ["F", "D0", "D+", "C0", "C+", "B0", "B+", "A0", "A+"]

for i in range(line):
    a, b, c = str(input()).split(" ")
    if(c == "P"):
        continue
    else:
        for j in range(len(grades)):
            if(c == grades[j]):
                score += j * 0.5 * int(float(b))
                if(j != 0):
                    score+=0.5 * int(float(b))
                num+=int(float(b))
                break


print(score/num)
        
        
            
