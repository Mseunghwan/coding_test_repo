import FinanceDataReader as fdr

# KOSPI Index 코스피 지수 데이터 
df = fdr.DataReader('KS11', '2020') # 2020-01-01 ~ 현재