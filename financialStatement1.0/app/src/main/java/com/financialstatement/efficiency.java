package com.financialstatement;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;
import java.math.*;
import android.text.*;


public class efficiency extends Activity
{
    private EditText mEdtOperateProfit,mEdtRevenue1,mEdtDepreciation1;
    private EditText mEdtReversoContext,mEdtDepreciation2,mEdtRevenue2;
    private TextView mOperateMargin,mDrcMargin,mdrMargin,mEfficiency;
    private Button btnOperateMargin,btnDrcMargin,btnDrMargin;

    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.efficiency);
        mEfficiency = findViewById(R.id.efficiency);
        mOperateMargin = findViewById(R.id.operateMargin);
        mDrcMargin = findViewById(R.id.drcMargin);
        mdrMargin = findViewById(R.id.drMargin);
        mEdtOperateProfit = findViewById(R.id.operateProfit);
        mEdtRevenue1 = findViewById(R.id.revenue1);
        mEdtDepreciation1 = findViewById(R.id.depreciation1);
        mEdtReversoContext = findViewById(R.id.reversoContext);
        mEdtDepreciation2 = findViewById(R.id.depreciation2);
        mEdtRevenue2 = findViewById(R.id.revenue2);
        btnOperateMargin = findViewById(R.id.btnOperateMargin);
        btnDrcMargin = findViewById(R.id.btnDrcMargin);
        btnDrMargin = findViewById(R.id.btnDrMargin);
        btnOperateMargin.setOnClickListener(btnOM);
        btnDrcMargin.setOnClickListener(btnDrcM);
        btnDrMargin.setOnClickListener(btnDrM);
    }
    private View.OnClickListener btnOM = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            String s1 = mEdtOperateProfit.getText().toString();
            String s2 = mEdtRevenue1.getText().toString();
            if(TextUtils.isEmpty(s1)||TextUtils.isEmpty(s2)){
                mEdtOperateProfit.setError("Error");
                mEdtRevenue1.setError("Error");
            }
            else{
                Double operateProfit = Double.parseDouble(mEdtOperateProfit.getText().toString());
                Double revenue1 = Double.parseDouble(mEdtRevenue1.getText().toString());
                if(operateProfit!=0&&revenue1!=0){
                    Double operateMargin = (operateProfit*100)/revenue1;
                    BigDecimal bd = new BigDecimal(operateMargin);
                    bd = bd.setScale(2,BigDecimal.ROUND_HALF_UP);
                    String strSug = getString(R.string.operate_margin);
                    strSug+=bd;
                    strSug+="%";
                    mOperateMargin.setText(strSug);
                    String strSug1 = getString(R.string.operatem);
                    mEfficiency.setText(strSug1);
                }
                else if((operateProfit==0&&revenue1==0)||(operateProfit!=0&&revenue1==0)){
                    String strSug = getString(R.string.none);
                    mOperateMargin.setText(strSug);
                    String strSug1 = getString(R.string.operatem);
                    mEfficiency.setText(strSug1);
                }
                else if(operateProfit==0&&revenue1!=0){
                    Double operateMargin = (operateProfit*100)/revenue1;
                    BigDecimal bd = new BigDecimal(operateMargin);
                    bd = bd.setScale(2,BigDecimal.ROUND_HALF_UP);
                    String strSug = getString(R.string.operate_margin);
                    strSug+=bd;
                    strSug+="%";
                    mOperateMargin.setText(strSug);
                    String strSug1 = getString(R.string.operatem);
                    mEfficiency.setText(strSug1);
                }
            }
        }
    };
    private View.OnClickListener btnDrcM = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            String s1 = mEdtDepreciation1.getText().toString();
            String s2 = mEdtReversoContext.getText().toString();
            if(TextUtils.isEmpty(s1)||TextUtils.isEmpty(s2)){
                mEdtDepreciation1.setError("Error");
                mEdtReversoContext.setError("Error");
            }
            else{
                double depreciation1 = Double.parseDouble(mEdtDepreciation1.getText().toString());
                double reversoContext = Double.parseDouble(mEdtReversoContext.getText().toString());
                if(depreciation1!=0&&reversoContext!=0){
                    double drcMargin = (depreciation1*100)/reversoContext;
                    BigDecimal bd = new BigDecimal(drcMargin);
                    bd = bd.setScale(2,BigDecimal.ROUND_HALF_UP);
                    String strSug = getString(R.string.drc_margin);
                    strSug+=bd;
                    strSug+="%";
                    mDrcMargin.setText(strSug);
                    String strSug1 = getString(R.string.drcm);
                    mEfficiency.setText(strSug1);
                }
                else if((depreciation1==0&&reversoContext==0)||(depreciation1!=0&&reversoContext==0)){
                    String strSug = getString(R.string.none);
                    mDrcMargin.setText(strSug);
                    String strSug1 = getString(R.string.drcm);
                    mEfficiency.setText(strSug1);
                }
                else if(depreciation1==0&&reversoContext!=0){
                    double drcMargin = (depreciation1*100)/reversoContext;
                    BigDecimal bd = new BigDecimal(drcMargin);
                    bd = bd.setScale(2,BigDecimal.ROUND_HALF_UP);
                    String strSug = getString(R.string.drc_margin);
                    strSug+=bd;
                    strSug+="%";
                    mDrcMargin.setText(strSug);
                    String strSug1 = getString(R.string.drcm);
                    mEfficiency.setText(strSug1);
                }
            }

        }
    };
    private View.OnClickListener btnDrM = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            String s1 = mEdtDepreciation2.getText().toString();
            String s2 = mEdtRevenue2.getText().toString();
            if(TextUtils.isEmpty(s1)||TextUtils.isEmpty(s2)){
                mEdtDepreciation2.setError("Error");
                mEdtRevenue2.setError("Error");
            }
            else{
                double depreciation2 = Double.parseDouble(mEdtDepreciation2.getText().toString());
                double revenue2 = Double.parseDouble(mEdtRevenue2.getText().toString());
                if(depreciation2!=0&&revenue2!=0){
                    double drMargin = (depreciation2*100)/revenue2;
                    BigDecimal bd = new BigDecimal(drMargin);
                    bd = bd.setScale(2,BigDecimal.ROUND_HALF_UP);
                    String strSug = getString(R.string.dr_margin);
                    strSug+=bd;
                    strSug+="%";
                    mdrMargin.setText(strSug);
                    String strSug1 = getString(R.string.drm);
                    mEfficiency.setText(strSug1);
                }
                else if((depreciation2==0&&revenue2==0)||(depreciation2!=0&&revenue2==0)){
                    String strSug = getString(R.string.none);
                    mdrMargin.setText(strSug);
                    String strSug1 = getString(R.string.drm);
                    mEfficiency.setText(strSug1);
                }
                else if(depreciation2==0&&revenue2!=0){
                    double drMargin = (depreciation2*100)/revenue2;
                    BigDecimal bd = new BigDecimal(drMargin);
                    bd = bd.setScale(2,BigDecimal.ROUND_HALF_UP);
                    String strSug = getString(R.string.dr_margin);
                    strSug+=bd;
                    strSug+="%";
                    mdrMargin.setText(strSug);
                    String strSug1 = getString(R.string.drm);
                    mEfficiency.setText(strSug1);
                }
            }
        }
    };

}