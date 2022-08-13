# -*- coding: utf-8 -*-
"""
Created on Wed Aug 10 23:52:08 2022

@author: 林則廷
"""

def FVOA(PMT,i,n):       #年金計算
    FVIFA = 0
    for t in range(1,n+1):
        FVIFA = FVIFA +((1+i)**(n-t))
    print('\n年金終值複利因子:',round(FVIFA,2))
    fv = PMT*FVIFA
    return(fv)
def PVOA(PMT,i,n):         #教育基金計算
    PVIFA = 0
    for t in range(1,n+1):
        PVIFA = PVIFA+((1+i)**(-t))
    PVA = PMT*PVIFA
    return(PVA)
def annuity(pv,i,n):      #年金給付貸款計算
    up = i*((1+i)**n)
    down = ((1+i)**n)-1
    result = pv*(up/down)
    return(result)
while True:
    choose = input('\n1.年金計算 2.教育基金試算 3.年金給付貸款計算(輸入1 or 2 or 3,輸入out跳出):')
    if(choose == '1'):
        PMT = int(input('\n輸入每個月存入金額:'))
        i = float(input('\n輸入年利率:'))
        n = int(input('\n輸入預計幾年後退休:'))
        print('\n%d年後的終值=%10.2f'%(n,FVOA(PMT, i/12, n*12)))
    elif(choose == '2'):
        cash = int(input('\n原始投資金額:'))
        PMT = int(input('\n輸入每年領回金額:'))
        n = int(input('\n輸入可以領回總年數:'))
        i = float(input('\n年利率:'))
        investment = round(PVOA(PMT, i, n),2)
        print('\n教育基金之投資方案現值:',investment)
        payoff = round(investment-cash,2)
        print('\n投資方案現值 - 原始投資金額 =',payoff)
        if(payoff < 0):
            print('\n負報酬,不建議購買')
        else:
            print('\n正報酬,建議可購買')
    elif(choose == '3'):
        i = float(input('\n輸入年利率:'))
        n = int(input('\n輸入貸款年數:'))
        pv = int(input('\n輸入貸款金額:'))
        print('\n每年應負貸款金額:%10.2f'%(annuity(pv, i, n)))
    else:
        break
    