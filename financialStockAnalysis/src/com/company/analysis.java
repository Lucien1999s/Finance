package com.company;

public enum analysis {
    NDY,                           //宣告變數
    BPC,
    SPC;
    public float i;
    public float j;
    public float n = 0.0F;

    float calculate(float pc, float nw, float cd, float sd, int payb, int pays) {         //接收主程式傳來參數
        switch (this) {
            case NDY -> {                                          //計算需要幾年回本
                do {
                    this.i = (pc - cd) / (1.0F + sd / 10.0F);
                    ++this.n;
                    pc = this.i;
                } while (pc > nw);
                return this.n;                      //回傳計算結果
            }
            case BPC -> {
                for (this.j = 0.0F; this.j < (float) payb; ++this.j) {         //計算建議買進價
                    this.n = (nw + cd) * (1.0F + sd / 10.0F);
                    nw = this.n;
                }
                return nw;                          //回傳計算結果
            }
            case SPC -> {                                                        //計算建議賣出價
                for (this.j = 0.0F; this.j < (float) pays; ++this.j) {
                    this.n = (nw + cd) * (1.0F + sd / 10.0F);
                    nw = this.n;
                }
                return nw;                           //回傳計算結果
            }
            default -> throw new AssertionError("Unknown" + this);     //輸入錯誤機制，回傳UNKNOWN
        }
    }
}
