package com.company;

public enum data {
    HUA("https://invest.cnyes.com/twstock/TWS/2880"),//設定DATA成員
    FUB("https://invest.cnyes.com/twstock/TWS/2881"),
    NAS("https://invest.cnyes.com/twstock/TWS/2882"),
    ESN("https://invest.cnyes.com/twstock/TWS/2884"),
    YUA("https://invest.cnyes.com/twstock/TWS/2885"),
    MEG("https://invest.cnyes.com/twstock/TWS/2886"),
    CTB("https://invest.cnyes.com/twstock/TWS/2891"),
    FCB("https://invest.cnyes.com/twstock/TWS/2892"),
    COO("https://invest.cnyes.com/twstock/TWS/5880"),
    OTHER("https://www.cnyes.com/");

    private String ur2;

    private data(String ur2) {
        this.ur2 = ur2;
    }          //建構

    public String ur2() {
        return this.ur2;
    }
}
