package com.financialstatement;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;
import java.math.*;
import android.text.*;

public class safemargin extends Activity
{
    private EditText mEdtNetProfit,mEdtInterstExpense,mEdtDOnPreferStock,mEdtCommonShare;
    private TextView mTie,mTipe,mEps,mSafeMargin;
    private Button btnTie,btnTipe,btnEps;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.safemargin);

        mSafeMargin = findViewById(R.id.safeMargin);
        mEdtNetProfit = findViewById(R.id.netProfit);
        mEdtInterstExpense = findViewById(R.id.interestExpense);
        mEdtDOnPreferStock = findViewById(R.id.dOnPreferStock);
        mEdtCommonShare = findViewById(R.id.nCommonShare);
        mTie = findViewById(R.id.tie);
        mTipe = findViewById(R.id.tipe);
        mEps = findViewById(R.id.eps);
        btnTie = findViewById(R.id.btnTie);
        btnTipe = findViewById(R.id.btnTipe);
        btnEps = findViewById(R.id.btnEps);

        btnTie.setOnClickListener(btnTies);
        btnTipe.setOnClickListener(btnTipes);
        btnEps.setOnClickListener(btnEpss);
    }
    private View.OnClickListener btnTies = new View.OnClickListener(){
        @Override
        public void onClick (View v){
            String s1 = mEdtNetProfit.getText().toString();
            String s2 = mEdtInterstExpense.getText().toString();
            if(TextUtils.isEmpty(s1)||TextUtils.isEmpty(s2)){
                mEdtNetProfit.setError("Error");
                mEdtInterstExpense.setError("Error");
            }
            else{
                Double netProfit = Double.parseDouble(mEdtNetProfit.getText().toString());
                Double interestExpense = Double.parseDouble(mEdtInterstExpense.getText().toString());
                if(interestExpense!=0){
                    Double tie = netProfit/interestExpense;
                    BigDecimal bd = new BigDecimal(tie);
                    bd = bd.setScale(2,BigDecimal.ROUND_HALF_UP);
                    String strSug = getString(R.string.tie);
                    strSug += bd;
                    strSug += " 倍";
                    mTie.setText(strSug);
                    String strSug1 = getString(R.string.xtie);
                    mSafeMargin.setText(strSug1);
                }
                else{
                    String strSug = getString(R.string.none);
                    mTie.setText(strSug);
                    String strSug1 = getString(R.string.xtie);
                    mSafeMargin.setText(strSug1);
                }
            }
        }
    };
    private View.OnClickListener btnTipes = new View.OnClickListener(){
        @Override
        public void onClick (View v){
            String s1= mEdtNetProfit.getText().toString();
            String s2= mEdtInterstExpense.getText().toString();
            String s3= mEdtDOnPreferStock.getText().toString();
            if(TextUtils.isEmpty(s1)||TextUtils.isEmpty(s2)||TextUtils.isEmpty(s3)){
                mEdtNetProfit.setError("Error");
                mEdtInterstExpense.setError("Error");
                mEdtDOnPreferStock.setError("Error");
            }
            else{
                Double netProfit = Double.parseDouble(mEdtNetProfit.getText().toString());
                Double interestExpense = Double.parseDouble(mEdtInterstExpense.getText().toString());
                Double dPreferStock = Double.parseDouble(mEdtDOnPreferStock.getText().toString());
                if(interestExpense==0&&dPreferStock==0){
                    String strSug = getString(R.string.none);
                    mTipe.setText(strSug);
                    String strSug1 = getString(R.string.xtipe);
                    mSafeMargin.setText(strSug1);
                }
                else{
                    Double tipe = netProfit/(interestExpense+dPreferStock);
                    BigDecimal bd = new BigDecimal(tipe);
                    bd = bd.setScale(2,BigDecimal.ROUND_HALF_UP);
                    String strSug = getString(R.string.tipe);
                    strSug += bd;
                    strSug += " 倍";
                    mTipe.setText(strSug);
                    String strSug1 = getString(R.string.xtipe);
                    mSafeMargin.setText(strSug1);
                }
            }
        }
    };
    private View.OnClickListener btnEpss = new View.OnClickListener(){
        @Override
        public void onClick (View v){
            String s1=mEdtNetProfit.getText().toString();
            String s2=mEdtInterstExpense.getText().toString();
            String s3=mEdtDOnPreferStock.getText().toString();
            String s4=mEdtCommonShare.getText().toString();
            if(TextUtils.isEmpty(s1)||TextUtils.isEmpty(s2)||TextUtils.isEmpty(s3)||TextUtils.isEmpty(s4)){
                mEdtNetProfit.setError("Error");
                mEdtInterstExpense.setError("Error");
                mEdtDOnPreferStock.setError("Error");
                mEdtCommonShare.setError("Error");
            }
            else{
                Double netProfit = Double.parseDouble(mEdtNetProfit.getText().toString());
                Double interestExpense = Double.parseDouble(mEdtInterstExpense.getText().toString());
                Double dPreferStock = Double.parseDouble(mEdtDOnPreferStock.getText().toString());
                Double nCommonShare = Double.parseDouble(mEdtCommonShare.getText().toString());
                if(nCommonShare!=0){
                    Double eps = (netProfit-(interestExpense+dPreferStock))/nCommonShare;
                    BigDecimal bd = new BigDecimal(eps);
                    bd = bd.setScale(2,BigDecimal.ROUND_HALF_UP);
                    String strSug = getString(R.string.eps);
                    strSug += bd;
                    strSug += " 元";
                    mEps.setText(strSug);
                    String strSug1 = getString(R.string.xeps);
                    mSafeMargin.setText(strSug1);
                }
                else{
                    String strSug = getString(R.string.none);
                    mEps.setText(strSug);
                    String strSug1 = getString(R.string.xeps);
                    mSafeMargin.setText(strSug1);
                }
            }
        }
    };
}