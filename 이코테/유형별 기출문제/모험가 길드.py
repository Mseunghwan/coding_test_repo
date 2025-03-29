import sys

input = sys.stdin.readline

n = int(input())

fearlist = list(map(int, input().split()))

fearlist.sort()

group_cnt = 0
group_member_cnt = 0

for i in fearlist:
    group_member_cnt += 1
    # 그룹 인원의 수가 공포도 보다 크거나 같으면 --> 그룹 하나로
    if group_member_cnt >= i:
        group_cnt += 1
        group_member_cnt = 0
    
print(group_member_cnt)