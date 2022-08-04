package com.financialstatement;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;
import android.content.*;
import java.math.*;
import android.text.*;

public class structure extends Activity
{
    private EditText mEdtCurrentAssets,mEdtCurrentLiabilities,mEdtInventory;
    private TextView mCurrentRatio,mQuickRatio,mStructure;
    private Button btnCurrentRatio,btnQuickRatio,btnDStructure;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.structure);

        mStructure = findViewById(R.id.structure);
        mEdtCurrentAssets = findViewById(R.id.currentAssets);
        mEdtCurrentLiabilities = findViewById(R.id.currentLiabilities);
        mEdtInventory = findViewById(R.id.inventory1);
        mCurrentRatio = findViewById(R.id.currentRatio);
        mQuickRatio = findViewById(R.id.QuickRatio);
        btnCurrentRatio = findViewById(R.id.btnCurrentRatio);
        btnQuickRatio = findViewById(R.id.btnQuickRatio);
        btnCurrentRatio.setOnClickListener(btnCurrentRatios);
        btnQuickRatio.setOnClickListener(btnQuickRatios);
        btnDStructure = findViewById(R.id.btnDStructures);

        btnDStructure.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent();
                intent.setClass(structure.this,dStructure.class);
                startActivity(intent);
            }
        });
    }
    private View.OnClickListener btnCurrentRatios = new View.OnClickListener(){
        @Override
        public void onClick (View v){
            String s1=mEdtCurrentAssets.getText().toString();
            String s2=mEdtCurrentLiabilities.getText().toString();
            if(TextUtils.isEmpty(s1)||TextUtils.isEmpty(s2)){
                mEdtCurrentAssets.setError("Error");
                mEdtCurrentLiabilities.setError("Error");
            }
            else{
                Double currentAssets = Double.parseDouble(mEdtCurrentAssets.getText().toString());
                Double currentLiabilities = Double.parseDouble(mEdtCurrentLiabilities.getText().toString());
                if(currentAssets!=0&&currentLiabilities!=0){
                    Double currentRatio = currentAssets/currentLiabilities;
                    BigDecimal bd = new BigDecimal(currentRatio);
                    bd = bd.setScale(2,BigDecimal.ROUND_HALF_UP);
                    String strSug = getString(R.string.currentRatio);
                    strSug += bd;
                    strSug += "比1";
                    mCurrentRatio.setText(strSug);
                    String strSug1 = getString(R.string.currentr);
                    mStructure.setText(strSug1);
                }
                else if((currentAssets==0&&currentLiabilities==0)||(currentAssets!=0&&currentLiabilities==0)){
                    String strSug = getString(R.string.none);
                    mCurrentRatio.setText(strSug);
                    String strSug1 = getString(R.string.currentr);
                    mStructure.setText(strSug1);
                }
                else if(currentAssets==0&&currentLiabilities!=0){
                    Double currentRatio = currentAssets/currentLiabilities;
                    BigDecimal bd = new BigDecimal(currentRatio);
                    bd = bd.setScale(2,BigDecimal.ROUND_HALF_UP);
                    String strSug = getString(R.string.currentRatio);
                    strSug += bd;
                    strSug += "比1";
                    mCurrentRatio.setText(strSug);
                    String strSug1 = getString(R.string.currentr);
                    mStructure.setText(strSug1);
                }
            }
        }
    };
    private View.OnClickListener btnQuickRatios = new View.OnClickListener(){
        @Override
        public void onClick (View v){
            String s1=mEdtCurrentAssets.getText().toString();
            String s2=mEdtCurrentLiabilities.getText().toString();
            String s3=mEdtInventory.getText().toString();
            if(TextUtils.isEmpty(s1)||TextUtils.isEmpty(s2)||TextUtils.isEmpty(s3)){
                mEdtCurrentAssets.setError("Error");
                mEdtCurrentLiabilities.setError("Error");
                mEdtInventory.setError("Error");
            }
            else{
                Double currentAssets = Double.parseDouble(mEdtCurrentAssets.getText().toString());
                Double currentLiabilities = Double.parseDouble(mEdtCurrentLiabilities.getText().toString());
                Double inventory = Double.parseDouble(mEdtInventory.getText().toString());
                if(currentLiabilities==0){
                    String strSug = getString(R.string.none);
                    mQuickRatio.setText(strSug);
                    String strSug1 = getString(R.string.quickr);
                    mStructure.setText(strSug1);
                }
                else {
                    Double quickRatio = (currentAssets-inventory)/currentLiabilities;
                    BigDecimal bd = new BigDecimal(quickRatio);
                    bd = bd.setScale(2,BigDecimal.ROUND_HALF_UP);
                    String strSug = getString(R.string.quickRatio);
                    strSug += bd;
                    strSug += "比1";
                    mQuickRatio.setText(strSug);
                    String strSug1 = getString(R.string.quickr);
                    mStructure.setText(strSug1);
                }
            }
        }
    };
}