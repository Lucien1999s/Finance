# -*- coding: utf-8 -*-
"""
Created on Sun Aug  7 15:43:07 2022

@author: 林則廷
"""

level1 = 540000 * 0.05
level2 = (1210000-540000) * 0.12
level3 = (2420000-1210000) * 0.2
level4 = (4530000-2420000) * 0.3

taxfree_younger = 92000
taxfree_elder = 138000
standard_d = 124000 
salary_d = 207000
disability_d = 207000
preschool_d = 120000
school_d = 25000
longterm_d = 120000

def level(income):
    if income < 0:
        tax = 0
    elif income <= 540000:
        tax = income * 0.05
    elif income <= 1210000:
        tax = level1 + ((income-540000)*0.12)
    elif income <= 2420000:
        tax = level1 + level2 +((income-1210000)*0.2)
    elif income <= 4530000:
        tax = level1 + level2 + level3 +((income-2420000)*0.3)
    else:
        tax = level1 + level2 + level3 + level4 +((income-4530000)*0.4)
    return tax

def single(income):
    age = int(input('\n免稅額(輸入年齡):'))
    if(age>=70):
        income -= taxfree_elder
        print('\n扣減淨額:',income)
    else:
        income -= taxfree_younger
        print('\n扣減淨額:',income)
    income -= standard_d
    print('\n標準扣除額扣減淨額',income)
    salary_status = input('\n是否適用薪資特別扣除額(輸入是 or 否):')
    if(salary_status == '是' or salary_status =='yes'):
        income -= salary_d
        print('\n薪資特別扣除額扣減淨額:',income)
    disability_status = input('\n是否適用身心障礙特別扣除額(輸入是 or 否):')
    if(disability_status == '是' or disability_status == 'yes'):
        income -= disability_d
        print('\n扣減淨額:',income)
    preschool = int(input('\n家中多少位學前幼童(沒有請輸入0):'))
    if(preschool > 0):
        income -= (preschool*(preschool_d+taxfree_younger))
        print('\n扣減淨額:',income)
    school = int(input('\n家中多少位在學學生(沒有請輸入0):'))
    if(school > 0):
        income -= (school*(school_d+taxfree_younger))
        print('\n扣減淨額:',income)
    investment = input('\n是否有儲蓄投資特別扣除額(輸入是 or 否):')
    if(investment == '是' or investment == 'yes'):
        investment_d = int(input('\n多少金額:'))
        income -= investment_d
        print('\n扣減淨額:',income)
    longterm = input('\n是否符合長期照顧特別扣除額(輸入是 or 否):')
    if(longterm == '是' or longterm == 'yes'):
        income -= longterm_d
    other = input('\n是否有其他特別扣除額(輸入是 or 否):')
    if(other == '是' or other == 'yes'):
        other_num = int(input('\n多少金額:'))
        income -= other_num
    return income
def couple(income1,income2):
    income = income1+income2
    age1 = int(input('\n免稅額(輸入本人年齡):'))
    age2 = int(input('\n免稅額(輸入配偶年齡):'))
    if(age1>=70 and age2>=70):
        income -= (taxfree_elder*2)
        print('\n扣減淨額:',income)
    else:
        income -= (taxfree_younger*2)
        print('\n扣減淨額:',income)
    income -= standard_d*2
    print('\n標準扣除額扣減淨額',income)
    salary_status = input('\n是否適用薪資特別扣除額(輸入是 or 否):')
    if(salary_status == '是' or salary_status =='yes'):
        salary_num = int(input('\n適用數量(1 or 2):'))
        if(salary_num != 1 or salary_num != 2):
            salary_num = 2
        income -= salary_d*salary_num
        print('\n薪資特別扣除額扣減淨額:',income)
    disability_status = input('\n是否適用身心障礙特別扣除額(輸入是 or 否):')
    if(disability_status == '是' or disability_status == 'yes'):
        disability_num = int(input('\n數量:'))
        if(disability_num<=0):
            disability_num = 1
        income -= disability_d*disability_num
        print('\n扣減淨額:',income)
    preschool = int(input('\n家中多少位學前幼童(沒有請輸入0):'))
    if(preschool > 0):
        income -= (preschool*(preschool_d+taxfree_younger))
        print('\n扣減淨額:',income)
    school = int(input('\n家中多少位在學學生(沒有請輸入0):'))
    if(school > 0):
        income -= (school*(school_d+taxfree_younger))
        print('\n扣減淨額:',income)
    investment = input('\n是否符合儲蓄投資特別扣除額(輸入是 or 否):')
    if(investment == '是' or investment == 'yes'):
        investment_d = int(input('多少金額:'))
        income -= investment_d
        print('\n扣減淨額:',income)
    longterm = input('\n是否符合長期照顧特別扣除額(輸入是 or 否):')
    if(longterm == '是' or longterm == 'yes'):
        longterm_num = int(input('\n數量:'))
        if(longterm_num<=0):
            longterm_num = 1
        income -= longterm_d
    other = input('\n是否有其他特別扣除額(輸入是 or 否):')
    if(other == '是' or other == 'yes'):
        other_num = int(input('\n多少金額:'))
        income -= other_num
    return income
def single_div(income):
    age = int(input('\n免稅額(義務納稅人年齡):'))
    if(age>=70):
        income -= taxfree_elder
        print('\n扣減淨額:',income)
    else:
        income -= taxfree_younger
        print('\n扣減淨額:',income)
    income -= standard_d*2
    print('\n標準扣除額扣減淨額',income)
    salary_status = input('\n是否適用薪資特別扣除額(輸入是 or 否):')
    if(salary_status == '是' or salary_status =='yes'):
        income -= salary_d
        print('\n扣減淨額:',income)
    disability_status = input('\n是否適用身心障礙特別扣除額(輸入是 or 否):')
    if(disability_status == '是' or disability_status == 'yes'):
        income -= disability_d
        print('\n扣減淨額:',income)
    preschool = int(input('\n家中多少位學前幼童(沒有請輸入0):'))
    if(preschool > 0):
        income -= (preschool*(preschool_d+taxfree_younger))
        print('\n扣減淨額:',income)
    school = int(input('\n家中多少位在學學生(沒有請輸入0):'))
    if(school > 0):
        income -= (school*(school_d+taxfree_younger))
        print('\n扣減淨額:',income)
    investment = input('\n是否有儲蓄投資特別扣除額(輸入是 or 否):')
    if(investment == '是' or investment == 'yes'):
        investment_d = int(input('\n多少金額:'))
        income -= investment_d
        print('\n扣減淨額:',income)
    longterm = input('\n是否符合長期照顧特別扣除額(輸入是 or 否):')
    if(longterm == '是' or longterm == 'yes'):
        income -= longterm_d
    other = input('\n是否有其他特別扣除額(輸入是 or 否):')
    if(other == '是' or other == 'yes'):
        other_num = int(input('\n多少金額:'))
        income -= other_num
    return income
def couple_div(income):
    age = int(input('\n免稅額(所得分開者年齡):'))
    if(age>=70):
        income -= taxfree_elder
        print('\n扣減淨額:',income)
    else:
        income -= taxfree_younger
        print('\n扣減淨額:',income)
    salary_status = input('\n是否適用薪資特別扣除額(輸入是 or 否):')
    if(salary_status == '是' or salary_status =='yes'):
        income -= salary_d
        print('\n薪資特別扣除額扣減淨額:',income)
    return income
def single_sort(income):
    age = int(input('\n免稅額(義務納稅人年齡):'))
    if(age>=70):
        income -= taxfree_elder
        print('\n扣減淨額:',income)
    else:
        income -= taxfree_younger
        print('\n扣減淨額:',income)
    salary_status = input('\n是否適用薪資特別扣除額(輸入是 or 否):')
    if(salary_status == '是' or salary_status =='yes'):
        income -= salary_d
        print('\n扣減淨額:',income)
    disability_status = input('\n是否適用身心障礙特別扣除額(輸入是 or 否):')
    if(disability_status == '是' or disability_status == 'yes'):
        income -= disability_d
        print('\n扣減淨額:',income)
    investment = input('\n是否有儲蓄投資特別扣除額(輸入是 or 否):')
    if(investment == '是' or investment == 'yes'):
        investment_d = int(input('\n多少金額:'))
        income -= investment_d
        print('\n扣減淨額:',income)
    other = input('\n是否有其他特別扣除額(輸入是 or 否):')
    if(other == '是' or other == 'yes'):
        other_num = int(input('\n多少金額:'))
        income -= other_num    
    return income
    
def couple_sort(income):    
    age = int(input('\n免稅額(所得分開者年齡):'))
    if(age>=70):
        income -= taxfree_elder
        print('\n扣減淨額:',income)
    else:
        income -= taxfree_younger
        print('\n扣減淨額:',income)
    income -= standard_d
    print('\n標準扣除額扣減淨額',income)
    salary_status = input('\n是否適用薪資特別扣除額(輸入是 or 否):')
    if(salary_status == '是' or salary_status =='yes'):
        income -= salary_d
        print('\n扣減淨額:',income)
    disability_status = input('\n是否適用身心障礙特別扣除額(輸入是 or 否):')
    if(disability_status == '是' or disability_status == 'yes'):
        income -= disability_d
        print('\n扣減淨額:',income)
    preschool = int(input('\n家中多少位學前幼童(沒有請輸入0):'))
    if(preschool > 0):
        income -= (preschool*(preschool_d+taxfree_younger))
        print('\n扣減淨額:',income)
    school = int(input('\n家中多少位在學學生(沒有請輸入0):'))
    if(school > 0):
        income -= (school*(school_d+taxfree_younger))
        print('\n扣減淨額:',income)
    investment = input('\n是否有儲蓄投資特別扣除額(輸入是 or 否):')
    if(investment == '是' or investment == 'yes'):
        investment_d = int(input('多少金額:'))
        income -= investment_d
        print('\n扣減淨額:',income)
    longterm = input('\n是否符合長期照顧特別扣除額(輸入是 or 否):')
    if(longterm == '是' or longterm == 'yes'):
        income -= longterm_d
    other = input('\n是否有其他特別扣除額(輸入是 or 否):')
    if(other == '是' or other == 'yes'):
        other_num = int(input('\n多少金額:'))
        income -= other_num    
    return income

while True:    
    s_status = input('輸入單身 or 夫妻 or 直接計算 (欲結束輸入out):')
    if(s_status == '單身'):
        print('\n--個人所得淨額計算--')
        income = int(input('\n個人年所得總額:'))
        income = single(income)
        print('\n最終所得淨額:',income)
        tax = level(income)
        print('\n<應繳稅額=',tax,'元>')
    elif(s_status == '夫妻'):
        print('\n建議:\n<總薪資所得較低者選合併計算>\n<薪資所得較高者選薪資所得分開計稅>\n<副業占比遠超本業者選各類所得分開計稅>')
        choose = int(input('\n1.薪資所得分開計稅 2.各類所得分開計稅 3.全部所得合併計稅(輸入數字選擇):'))
        if(choose == 1):
            print('\n--薪資所得分開計稅(建議新高者為義務納稅人)--')
            income1 = int(input('\n義務納稅人年所得總額:'))
            income2 = int(input('\n所得分開者年所得總額:'))
            income = single_div(income1)
            print('\n義務納稅人年淨值:',income)
            income_other = couple_div(income2)
            print('\n其他淨值:',income_other)
            tax1 = level(income)
            tax2 = level(income_other)
            tax = tax1 + tax2
            print('\n<應繳稅額=',tax,'元>')
        elif(choose == 2):
            print('\n--各類所得分開計稅(建議薪低者為義務納稅人)--')
            income1 = int(input('\n義務納稅人年所得總額:'))
            income2 = int(input('\n所得分開者年所得總額:'))
            income = single_sort(income1)
            print('\n義務納稅人年淨值:',income)
            income_other = couple_sort(income2)
            print('\n其他淨值:',income_other)
            tax1 = level(income)
            tax2 = level(income_other)
            tax = tax1 + tax2
            print('\n<應繳稅額=',tax,'元>')
        else:
            print('\n--全部所得合併計稅--')
            income1 = int(input('\n本人年所得總額:'))
            income2 = int(input('\n配偶年所得總額:'))
            income = couple(income1, income2)
            print('\n最終所得淨額:',income)
            tax = level(income)
            print('\n<應繳稅額=',tax,'元>')
    elif(s_status == 'out'):
        break       
    else:    
        income = int(input('\n年所得稅淨額:'))
        tax = level(income)
        print('\n<應繳稅額=',tax,'元>')