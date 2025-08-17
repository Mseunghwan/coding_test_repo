T = int(input())

for case in range(T) : 

    N = int(input())

    oneja = []
    # 각각의 x, y, 방향, 방출에너지 값 저장
    for i in range(N) : 
        oneja.append(list(map(int, input().split())))
    
    rs = 0
    # 맵을 벗어나거나, 마주쳐서 터지면 True로 바꿈
    flag = [False] * N
    while(False in flag) : 
        # 움직임
        for i in range(len(oneja)) :
            if -1000 <= oneja[i][0] <= 1000 and -1000 <= oneja[i][1] <= 1000 and flag[i] == False: 
                if oneja[i][2] == 0 :
                    oneja[i][1] += 0.5

                elif oneja[i][2] == 1 :
                    oneja[i][1] -= 0.5

                elif oneja[i][2] == 2 :
                    oneja[i][0] -= 0.5

                elif oneja[i][2] == 3 :
                    oneja[i][0] += 0.5
            else : 
                flag[i] = True

        # 확인
        for i in range(len(oneja)) :
            for j in range(len(oneja)) :
                if i == j : 
                    continue 
                if flag[i] == False and flag[j] == False :
                    if oneja[i][0] == oneja[j][0] and oneja[i][1] == oneja[j][1] :
                        rs += oneja[i][3] + oneja[j][3]
                        print(rs)
                        flag[i] = True
                        flag[j] = True
                        break


    print(oneja)



    print(f"#{case + 1} {rs}")