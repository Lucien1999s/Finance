package com.financialstatement;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;
import java.math.*;
import android.text.*;

public class valueprice extends Activity
{
    private EditText mEdtBond,mEdtPrefer,mEdtCommon,mEdtSurplus,mEdtGoodwill,mEdtPreferShare,mEdtCommonShare;
    private TextView mBondValue,mPreferValue,mCommonValue,mValuePrice;
    private Button btnBondValue,btnPreferValue,btnCommonValue;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.valueprice);

        mValuePrice = findViewById(R.id.valuePrice);
        mEdtBond = findViewById(R.id.bond);
        mEdtPrefer = findViewById(R.id.prefer);
        mEdtCommon = findViewById(R.id.common);
        mEdtSurplus =findViewById(R.id.surplus);
        mEdtGoodwill = findViewById(R.id.goodwill);
        mEdtPreferShare =findViewById(R.id.preferShare);
        mEdtCommonShare =findViewById(R.id.commonShare);
        mBondValue = findViewById(R.id.bondValue);
        mPreferValue = findViewById(R.id.preferValue);
        mCommonValue = findViewById(R.id.commonValue);
        btnBondValue = findViewById(R.id.btnBondValue);
        btnPreferValue = findViewById(R.id.btnPreferValue);
        btnCommonValue = findViewById(R.id.btnCommonValue);
        btnBondValue.setOnClickListener(bondValues);
        btnPreferValue.setOnClickListener(preferValues);
        btnCommonValue.setOnClickListener(commonValues);
    }
    private View.OnClickListener bondValues = new View.OnClickListener(){
        @Override
        public void onClick (View v){
            String s1=mEdtBond.getText().toString();
            String s2=mEdtPrefer.getText().toString();
            String s3=mEdtCommon.getText().toString();
            String s4=mEdtSurplus.getText().toString();
            String s5=mEdtGoodwill.getText().toString();
            if(TextUtils.isEmpty(s1)||TextUtils.isEmpty(s2)||TextUtils.isEmpty(s3)||TextUtils.isEmpty(s4)||TextUtils.isEmpty(s5)){
                mEdtBond.setError("Error");
                mEdtPrefer.setError("Error");
                mEdtCommon.setError("Error");
                mEdtSurplus.setError("Error");
                mEdtGoodwill.setError("Error");
            }
            else{
                Double bond = Double.parseDouble(mEdtBond.getText().toString());
                Double prefer = Double.parseDouble(mEdtPrefer.getText().toString());
                Double common = Double.parseDouble(mEdtCommon.getText().toString());
                Double surplus = Double.parseDouble(mEdtSurplus.getText().toString());
                Double goodwill = Double.parseDouble(mEdtGoodwill.getText().toString());
                if(bond!=0){
                    Double bondvalue = (((bond+prefer+common+surplus)-goodwill)/bond)*1000;
                    BigDecimal bd = new BigDecimal(bondvalue);
                    bd = bd.setScale(2,BigDecimal.ROUND_HALF_UP);
                    String strSug = getString(R.string.bondvalue);
                    strSug += bd;
                    strSug += " 元";
                    mBondValue.setText(strSug);
                    String strSug1 = getString(R.string.bondv);
                    mValuePrice.setText(strSug1);
                }
                else{
                    String strSug = getString(R.string.none);
                    mBondValue.setText(strSug);
                    String strSug1 = getString(R.string.bondv);
                    mValuePrice.setText(strSug1);
                }
            }
        }
    };
    private View.OnClickListener preferValues = new View.OnClickListener(){
        @Override
        public void onClick (View v){
            String s1=mEdtPrefer.getText().toString();
            String s2=mEdtCommon.getText().toString();
            String s3=mEdtSurplus.getText().toString();
            String s4=mEdtGoodwill.getText().toString();
            String s5=mEdtPreferShare.getText().toString();
            if(TextUtils.isEmpty(s1)||TextUtils.isEmpty(s2)||TextUtils.isEmpty(s3)||TextUtils.isEmpty(s4)||TextUtils.isEmpty(s5)){
                mEdtPrefer.setError("Error");
                mEdtCommon.setError("Error");
                mEdtSurplus.setError("Error");
                mEdtGoodwill.setError("Error");
                mEdtPreferShare.setError("Error");
            }
            else{
                Double prefer = Double.parseDouble(mEdtPrefer.getText().toString());
                Double common = Double.parseDouble(mEdtCommon.getText().toString());
                Double surplus = Double.parseDouble(mEdtSurplus.getText().toString());
                Double goodwill = Double.parseDouble(mEdtGoodwill.getText().toString());
                Double prefershare = Double.parseDouble(mEdtPreferShare.getText().toString());
                if(prefershare!=0){
                    Double prefervalue = ((prefer+common+surplus)-goodwill)/prefershare;
                    BigDecimal bd = new BigDecimal(prefervalue);
                    bd = bd.setScale(2,BigDecimal.ROUND_HALF_UP);
                    String strSug = getString(R.string.prefervalue);
                    strSug += bd;
                    strSug += " 元";
                    mPreferValue.setText(strSug);
                    String strSug1 = getString(R.string.preferv);
                    mValuePrice.setText(strSug1);
                }
                else{
                    String strSug = getString(R.string.none);
                    mPreferValue.setText(strSug);
                    String strSug1 = getString(R.string.preferv);
                    mValuePrice.setText(strSug1);
                }
            }
        }
    };
    private View.OnClickListener commonValues = new View.OnClickListener(){
        @Override
        public void onClick (View v){
            String s1=mEdtPrefer.getText().toString();
            String s2=mEdtCommon.getText().toString();
            String s3=mEdtSurplus.getText().toString();
            String s4=mEdtGoodwill.getText().toString();
            String s5=mEdtPreferShare.getText().toString();
            String s6=mEdtCommonShare.getText().toString();
            if(TextUtils.isEmpty(s1)||TextUtils.isEmpty(s2)||TextUtils.isEmpty(s3)||TextUtils.isEmpty(s4)||TextUtils.isEmpty(s5)||TextUtils.isEmpty(s6)){
                mEdtPrefer.setError("Error");
                mEdtCommon.setError("Error");
                mEdtSurplus.setError("Error");
                mEdtGoodwill.setError("Error");
                mEdtPreferShare.setError("Error");
                mEdtCommonShare.setError("Error");
            }
            else{
                Double prefer = Double.parseDouble(mEdtPrefer.getText().toString());
                Double common = Double.parseDouble(mEdtCommon.getText().toString());
                Double surplus = Double.parseDouble(mEdtSurplus.getText().toString());
                Double goodwill = Double.parseDouble(mEdtGoodwill.getText().toString());
                Double prefershare = Double.parseDouble(mEdtPreferShare.getText().toString());
                Double commonshare = Double.parseDouble(mEdtCommonShare.getText().toString());
                if(commonshare!=0&&prefershare!=0){
                    Double commonvalue = (((prefer+common+surplus)-goodwill)-(((prefer/prefershare)*1.05)*prefershare))/commonshare;
                    BigDecimal bd = new BigDecimal(commonvalue);
                    bd = bd.setScale(2,BigDecimal.ROUND_HALF_UP);
                    String strSug = getString(R.string.commonvalue);
                    strSug += bd;
                    strSug += " 元";
                    mCommonValue.setText(strSug);
                    String strSug1 = getString(R.string.commonv);
                    mValuePrice.setText(strSug1);
                }
                else if(commonshare!=0){
                    Double commonvalue = ((common+surplus)-goodwill)/commonshare;
                    BigDecimal bd = new BigDecimal(commonvalue);
                    bd = bd.setScale(2,BigDecimal.ROUND_HALF_UP);
                    String strSug = getString(R.string.commonvalue);
                    strSug += bd;
                    strSug += " 元";
                    mCommonValue.setText(strSug);
                    String strSug1 = getString(R.string.commonv);
                    mValuePrice.setText(strSug1);
                }
                else{
                    String strSug = getString(R.string.none);
                    mCommonValue.setText(strSug);
                    String strSug1 = getString(R.string.commonv);
                    mValuePrice.setText(strSug1);
                }
            }
        }
    };
}