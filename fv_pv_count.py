# -*- coding: utf-8 -*-
"""
Created on Wed Aug 10 23:07:17 2022

@author: 林則廷
"""

def fvCount(pv,i,n):     #計算終值
    result = pv*(1+i)**n
    return(result)
def pvCount(fv,i,n):     #計算現值
    result = fv/((1+i)**n)
    return(result)
while True:
    choose = input('1.計算現值 2.計算終值(輸入 pv or fv ,輸入 out 跳出):')
    if(choose == 'pv'):
        fv = float(input('\n輸入終值:'))
        i = float(input('\n輸入折現率:'))
        n = int(input('\n輸入幾年前:'))
        print('\n%d年前的現值=%6.2f'%(n,pvCount(fv, i, n)))
    elif(choose == 'fv'):
        pv = float(input('\n輸入現值:'))
        i = float(input('\n輸入年利率:'))
        n = int(input('\n計算終值的年數:'))
        print('\n%d年後的終值=%6.2f'%(n,fvCount(pv, i, n)))
    else:
        break