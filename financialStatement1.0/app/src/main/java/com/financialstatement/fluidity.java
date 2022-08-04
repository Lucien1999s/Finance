package com.financialstatement;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;
import java.math.*;
import android.text.*;

public class fluidity extends Activity
{
    private EditText mEdtRevenue3,mEdtInvestory,mEdtReceivable,mEdtRevenue4;
    private TextView inventoryTurnover,dsiReceivable,mFluidity;
    private Button btnInventoryTurnover,btnDsiReceivable;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fluidity);

        mFluidity = findViewById(R.id.fluidity);
        mEdtRevenue3 = findViewById(R.id.revenue3);
        mEdtInvestory = findViewById(R.id.investory);
        mEdtReceivable = findViewById(R.id.receivable);
        mEdtRevenue4 = findViewById(R.id.revenue4);
        inventoryTurnover = findViewById(R.id.inventoryTurnover);
        dsiReceivable = findViewById(R.id.dsiReceivable);
        btnInventoryTurnover = findViewById(R.id.btnInventoryTurnover);
        btnDsiReceivable = findViewById(R.id.btnDsiReceivable);

        btnInventoryTurnover.setOnClickListener(btnIT);
        btnDsiReceivable.setOnClickListener(btnDR);
    }
    private View.OnClickListener btnIT = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            String s1=mEdtRevenue3.getText().toString();
            String s2=mEdtInvestory.getText().toString();
            if(TextUtils.isEmpty(s1)||TextUtils.isEmpty(s2)){
                mEdtRevenue3.setError("Error");
                mEdtInvestory.setError("Error");
            }
            else{
                Double revenue = Double.parseDouble(mEdtRevenue3.getText().toString());
                Double investory = Double.parseDouble(mEdtInvestory.getText().toString());
                if(revenue!=0&&investory!=0){
                    Double investoryTurnover = revenue/investory;
                    BigDecimal bd = new BigDecimal(investoryTurnover);
                    bd = bd.setScale(2,BigDecimal.ROUND_HALF_UP);
                    String strSug = getString(R.string.inventory_t);
                    strSug += bd;
                    strSug += " 次";
                    inventoryTurnover.setText(strSug);
                    String strSug1 = getString(R.string.inventoryt);
                    mFluidity.setText(strSug1);
                }
                else if((revenue==0&&investory==0)||(revenue!=0&&investory==0)){
                    String strSug = getString(R.string.none);
                    inventoryTurnover.setText(strSug);
                    String strSug1 = getString(R.string.inventoryt);
                    mFluidity.setText(strSug1);
                }
                else if (revenue==0&&investory!=0){
                    Double investoryTurnover = revenue/investory;
                    BigDecimal bd = new BigDecimal(investoryTurnover);
                    bd = bd.setScale(2,BigDecimal.ROUND_HALF_UP);
                    String strSug = getString(R.string.inventory_t);
                    strSug += bd;
                    strSug += " 次";
                    inventoryTurnover.setText(strSug);
                    String strSug1 = getString(R.string.inventoryt);
                    mFluidity.setText(strSug1);
                }
            }
        }
    };
    private View.OnClickListener btnDR = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            String s1=mEdtReceivable.getText().toString();
            String s2=mEdtRevenue4.getText().toString();
            if(TextUtils.isEmpty(s1)||TextUtils.isEmpty(s2)){
                mEdtReceivable.setError("Error");
                mEdtRevenue4.setError("Error");
            }
            else{
                Double receivable = Double.parseDouble(mEdtReceivable.getText().toString());
                Double revenue = Double.parseDouble(mEdtRevenue4.getText().toString());
                if(receivable!=0&&revenue!=0){
                    Double dsiReceivables = receivable/(revenue/365);
                    BigDecimal bd = new BigDecimal(dsiReceivables);
                    bd = bd.setScale(2,BigDecimal.ROUND_HALF_UP);
                    String strSug = getString(R.string.dsi_receive);
                    strSug += bd;
                    strSug += " 天";
                    dsiReceivable.setText(strSug);
                    String strSug1 = getString(R.string.dsir);
                    mFluidity.setText(strSug1);
                }
                else if((receivable==0&&revenue==0)||(receivable!=0&&revenue==0)){
                    String strSug = getString(R.string.none);
                    dsiReceivable.setText(strSug);
                    String strSug1 = getString(R.string.dsir);
                    mFluidity.setText(strSug1);
                }
                else if(receivable==0&&revenue!=0){
                    Double dsiReceivables = receivable/(revenue/365);
                    BigDecimal bd = new BigDecimal(dsiReceivables);
                    bd = bd.setScale(2,BigDecimal.ROUND_HALF_UP);
                    String strSug = getString(R.string.dsi_receive);
                    strSug += bd;
                    strSug += " 天";
                    dsiReceivable.setText(strSug);
                    String strSug1 = getString(R.string.dsir);
                    mFluidity.setText(strSug1);
                }
            }
        }
    };
}