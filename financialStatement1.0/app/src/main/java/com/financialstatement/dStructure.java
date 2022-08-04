package com.financialstatement;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;
import java.math.*;
import android.text.*;

public class dStructure extends Activity
{
    private EditText mEdtLongLiabilities,mEdtPreferStock,mEdtCommonStock,mEdtCapitalSurplus;
    private TextView mrll,mrps,mrcs,mDstructure;
    private Button btnrll,btnrps,btnrcs;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dstruct);

        mDstructure = findViewById(R.id.dstructure);
        mEdtLongLiabilities = findViewById(R.id.longLiabilities);
        mEdtPreferStock = findViewById(R.id.preferStock);
        mEdtCommonStock = findViewById(R.id.commonStock);
        mEdtCapitalSurplus = findViewById(R.id.capitalSurplus);
        mrll = findViewById(R.id.rll);
        mrps = findViewById(R.id.rps);
        mrcs = findViewById(R.id.rcs);
        btnrll = findViewById(R.id.btnrll);
        btnrps = findViewById(R.id.btnrps);
        btnrcs = findViewById(R.id.btnrcs);

        btnrll.setOnClickListener(btnrlls);
        btnrps.setOnClickListener(btnrpss);
        btnrcs.setOnClickListener(btnrcss);
    }
    private View.OnClickListener btnrlls = new View.OnClickListener(){
        @Override
        public void onClick (View v){
            String s1=mEdtLongLiabilities.getText().toString();
            String s2=mEdtPreferStock.getText().toString();
            String s3=mEdtCommonStock.getText().toString();
            String s4=mEdtCapitalSurplus.getText().toString();
            if(TextUtils.isEmpty(s1)||TextUtils.isEmpty(s2)||TextUtils.isEmpty(s3)||TextUtils.isEmpty(s4)){
                mEdtLongLiabilities.setError("Error");
                mEdtPreferStock.setError("Error");
                mEdtCommonStock.setError("Error");
                mEdtCapitalSurplus.setError("Error");
            }
            else{
                Double longLiabilities = Double.parseDouble(mEdtLongLiabilities.getText().toString());
                Double preferStock = Double.parseDouble(mEdtPreferStock.getText().toString());
                Double commonStock = Double.parseDouble(mEdtCommonStock.getText().toString());
                Double capitalSurplus = Double.parseDouble(mEdtCapitalSurplus.getText().toString());
                if(longLiabilities==0&&preferStock==0&&commonStock==0&&capitalSurplus==0){
                    String strSug = getString(R.string.none);
                    mrll.setText(strSug);
                    String strSug1 = getString(R.string.longl);
                    mDstructure.setText(strSug1);
                }
                else{
                    Double rll = (longLiabilities*100)/(longLiabilities+preferStock+commonStock+capitalSurplus);
                    BigDecimal bd = new BigDecimal(rll);
                    bd = bd.setScale(2,BigDecimal.ROUND_HALF_UP);
                    String strSug = getString(R.string.longLiabi);
                    strSug += bd;
                    strSug += " %";
                    mrll.setText(strSug);
                    String strSug1 = getString(R.string.longl);
                    mDstructure.setText(strSug1);
                }
            }

        }
    };
    private View.OnClickListener btnrpss = new View.OnClickListener(){
        @Override
        public void onClick (View v){
            String s1=mEdtLongLiabilities.getText().toString();
            String s2=mEdtPreferStock.getText().toString();
            String s3=mEdtCommonStock.getText().toString();
            String s4=mEdtCapitalSurplus.getText().toString();
            if(TextUtils.isEmpty(s1)||TextUtils.isEmpty(s2)||TextUtils.isEmpty(s3)||TextUtils.isEmpty(s4)){
                mEdtLongLiabilities.setError("Error");
                mEdtPreferStock.setError("Error");
                mEdtCommonStock.setError("Error");
                mEdtCapitalSurplus.setError("Error");
            }
            else{
                Double longLiabilities = Double.parseDouble(mEdtLongLiabilities.getText().toString());
                Double preferStock = Double.parseDouble(mEdtPreferStock.getText().toString());
                Double commonStock = Double.parseDouble(mEdtCommonStock.getText().toString());
                Double capitalSurplus = Double.parseDouble(mEdtCapitalSurplus.getText().toString());
                if(longLiabilities==0&&preferStock==0&&commonStock==0&&capitalSurplus==0){
                    String strSug = getString(R.string.none);
                    mrps.setText(strSug);
                    String strSug1 = getString(R.string.prefers);
                    mDstructure.setText(strSug1);
                }
                else{
                    Double rps = (preferStock*100)/(longLiabilities+preferStock+commonStock+capitalSurplus);
                    BigDecimal bd = new BigDecimal(rps);
                    bd = bd.setScale(2,BigDecimal.ROUND_HALF_UP);
                    String strSug = getString(R.string.preferstock);
                    strSug += bd;
                    strSug += " %";
                    mrps.setText(strSug);
                    String strSug1 = getString(R.string.prefers);
                    mDstructure.setText(strSug1);
                }
            }
        }
    };
    private View.OnClickListener btnrcss = new View.OnClickListener(){
        @Override
        public void onClick (View v){
            String s1=mEdtLongLiabilities.getText().toString();
            String s2=mEdtPreferStock.getText().toString();
            String s3=mEdtCommonStock.getText().toString();
            String s4=mEdtCapitalSurplus.getText().toString();
            if(TextUtils.isEmpty(s1)||TextUtils.isEmpty(s2)||TextUtils.isEmpty(s3)||TextUtils.isEmpty(s4)){
                mEdtLongLiabilities.setError("Error");
                mEdtPreferStock.setError("Error");
                mEdtCommonStock.setError("Error");
                mEdtCapitalSurplus.setError("Error");
            }
            else{
                Double longLiabilities = Double.parseDouble(mEdtLongLiabilities.getText().toString());
                Double preferStock = Double.parseDouble(mEdtPreferStock.getText().toString());
                Double commonStock = Double.parseDouble(mEdtCommonStock.getText().toString());
                Double capitalSurplus = Double.parseDouble(mEdtCapitalSurplus.getText().toString());
                if(longLiabilities==0&&preferStock==0&&commonStock==0&&capitalSurplus==0){
                    String strSug = getString(R.string.none);
                    mrcs.setText(strSug);
                    String strSug1 = getString(R.string.commons);
                    mDstructure.setText(strSug1);
                }
                else{
                    Double rcs = ((commonStock+capitalSurplus)*100)/(longLiabilities+preferStock+commonStock+capitalSurplus);
                    BigDecimal bd = new BigDecimal(rcs);
                    bd = bd.setScale(2,BigDecimal.ROUND_HALF_UP);
                    String strSug = getString(R.string.commonstock);
                    strSug += bd;
                    strSug += " %";
                    mrcs.setText(strSug);
                    String strSug1 = getString(R.string.commons);
                    mDstructure.setText(strSug1);
                }
            }
        }
    };
}