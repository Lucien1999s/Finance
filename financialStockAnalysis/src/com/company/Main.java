package com.company;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);                          //提示頁面
        System.out.println("\nTAIWAN FINANCIAL STOCKS FILTER\n");
        System.out.println("""
                華南金:HUA 富邦金:FUB 國泰金:NAS
                玉山金:ESN 元大金:YUA 兆豐金:MEG
                中信金:CTB 第一金:FCB 合庫金:COO
                Other stock:OTHER
                """);
        try {
            System.out.println("please choose a company:");                 //輸入選擇公司
            String company = scanner.next();
            System.out.println("\nNet worth,Five-year average cash,stock dividend:");
            System.out.println(data.valueOf(company).ur2());                 //顯示公司資料
            System.out.println("\nplease key price:");                        //輸入價格、淨值、五年平均現金股利和股票股利
            float price = scanner.nextFloat();
            System.out.println("please key net worth:");
            float networth = scanner.nextFloat();
            System.out.println("please key how many years average cash dividend:");
            int num = scanner.nextInt();
            float[] cashD = new float[num];
            for (int i=0;i<num;i++){
                System.out.print("->");
                cashD[i] = scanner.nextFloat();
            }
            Float cashd = average(cashD);
            System.out.println(cashd);

            System.out.println("please key stock dividend:");
            float[] stockD = new float[num];
            for (int i=0;i<num;i++){
                System.out.print("->");
                stockD[i] = scanner.nextFloat();
            }
            Float stockd = average(stockD);
            System.out.println(stockd);

            System.out.println("\n(Financial suggest:3~6)  (Electronic suggest:4~10)  (Business Cycle suggest:4~8)");
            System.out.println("please key payback value(buy):");               //提示字句列印和輸入回本倍參數
            int paybackb = scanner.nextInt();
            System.out.println("please key payback value(sell):");
            int paybacks = scanner.nextInt();

            System.out.println("price:" + price);                         //列印輸入資訊
            System.out.println("net worth:" + networth);
            System.out.println("cash dividend:" + cashd);
            System.out.println("stock dividend:" + stockd);
            System.out.println("------------------------------");

            float needyears = analysis.NDY.calculate(price, networth, cashd, stockd, paybackb, paybacks);  //呼叫分析類別回傳值
            float buyprice = analysis.BPC.calculate(price, networth, cashd, stockd, paybackb, paybacks);
            float sellprice = analysis.SPC.calculate(price, networth, cashd, stockd, paybackb, paybacks);
            System.out.println("To net worth need years = " + needyears);           //列印回傳值<幾年回本、建議買進賣出價>
            System.out.println("Suggest buy price = " + buyprice);
            System.out.println("Suggest sell price = " + sellprice);
        }catch (IllegalArgumentException e){System.out.println(e);}
    }
    public static float average(float[] number){             //計算平均
        int lengths=number.length;
        float total = 0;
        for(float a:number){
            total+=a;
        }
        return total/lengths;
    }
}
