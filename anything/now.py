import sys

input = sys.stdin.readline

sys.setrecursionlimit(10**6)

N = int(input())

budget = list(map(int, input().split()))
budget.sort()

M = int(input())



def search(start, end, result) : 
    # 종료 조건 : 탐색 범위가 더 이상 없을 때. 최적의 답을 반환
    if start > end : 
        return result
    
    mid = (start + end) // 2
    
    # mid를 상한액으로 가정, 총 배정액 계산
    total = 0
    for price in budget : 
        total += min(price, mid)
    
    # total 예산액 안이라면, 더 좋은 답 찾아 오른쪽 부분 탐색
    if total <= M : 
        # mid는 유효한 답이므로 reulst 자리에 mid 넘겨주기
        return search(mid + 1, end, mid)

    else : 
        # total 예산액 초과, 상한액 낮추기 위해 왼쪽으로
        # mid는 답이 아니므로 result 그대로 넘겨 줌
        return search(start, mid - 1, result)

    
if sum(budget) <= M : 
    print(max(budget))
else : 
    # 최적의 상한액을 구하기 위해 값 범위 설정
    start = 0
    end = max(budget)
    result = search(start, end, 0)
    print(result)
    


# 예제 1 (requests = [120, 110, 140, 150], M = 485)로 따라가기
# 초기 검사: 120+110+140+150 = 520 이므로 485보다 큽니다. 이분 탐색을 시작합니다.
# 탐색 범위: start = 0, end = 150
# 반복:
# 1회차: mid = 75. 배정액: 75+75+75+75 = 300. 300 <= 485 이므로 result = 75, start = 76.
# 2회차: start = 76, end = 150. mid = 113. 배정액: 110+113+113+113 = 449. 449 <= 485 이므로 result = 113, start = 114.
# 3회차: start = 114, end = 150. mid = 132. 배정액: 110+120+132+132 = 494. 494 > 485 이므로 end = 131.
# 4회차: start = 114, end = 131. mid = 122. 배정액: 110+120+122+122 = 474. 474 <= 485 이므로 result = 122, start = 123.
# 5회차: start = 123, end = 131. mid = 127. 배정액: 110+120+127+127 = 484. 484 <= 485 이므로 result = 127, start = 128.
# 6회차: start = 128, end = 131. mid = 129. 배정액: 110+120+129+129 = 488. 488 > 485 이므로 end = 128.
# ... 반복 ...