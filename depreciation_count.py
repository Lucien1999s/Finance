# -*- coding: utf-8 -*-
"""
Created on Wed Aug 10 21:32:17 2022

@author: 林則廷
"""

import numpy as np
def straightline(cost,salvage,n):  #直線法公式
    return ((cost-salvage)/n)
def slinetable(exp_list,n,cost):   #計算折舊費用分攤表
    acm_exp = 0
    sline_result = []
    row = []
    for i in range(0,n):
        acm_exp = acm_exp+exp_list[i]
        balance = cost - acm_exp
        row.append(i+1)
        row.append(exp_list[i])
        row.append(acm_exp)
        row.append(balance)
        sline_result.append(row)
        row = []
    return(sline_result)

while True:
    cost = int(input('\n固定資產成本:'))
    salvage = int(input('\n估計殘值:'))
    n = int(input('\n欲計算年度:'))
    print('\n')
    sline_exp = straightline(cost, salvage, n)
    sline_exp_list = list(np.linspace(sline_exp,sline_exp,n))
    slt = slinetable(sline_exp_list,n,cost)
    print('%3s%8s%8s%8s'%('年度','折舊費用','累計折舊','期末帳面價值'))
    for i in range(0,n):
        print('%4d%10d%12d%14d'%(slt[i][0],slt[i][1],slt[i][2],slt[i][3]))
    out = input('\n欲停止請輸入out:')
    if (out == 'out'):
        break