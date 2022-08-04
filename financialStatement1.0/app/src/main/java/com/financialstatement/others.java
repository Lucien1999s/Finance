package com.financialstatement;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;
import java.math.*;
import android.media.*;
import android.text.*;

public class others extends Activity
{
    private EditText mEdtNetProfit,mEdtMoveSurplus,mEdtPrice,mEdtEps;
    private TextView mOms,mPeratio,mOther;
    private Button btnOms,btnPeratio;
    private ImageView ludee;
    private MediaPlayer mediaPlayer;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.others);

        mOther = findViewById(R.id.other);
        mEdtNetProfit = findViewById(R.id.netProfit);
        mEdtMoveSurplus = findViewById(R.id.moveSurplus);
        mEdtPrice = findViewById(R.id.price);
        mEdtEps = findViewById(R.id.eps);
        mOms = findViewById(R.id.oms);
        mPeratio = findViewById(R.id.peratio);
        btnOms = findViewById(R.id.btnOms);
        btnPeratio = findViewById(R.id.btnPeratio);

        ImageView ludee =(ImageView)findViewById(R.id.lude);
        ludee.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(mediaPlayer==null){
                    mediaPlayer = MediaPlayer.create(others.this,R.raw.lostchild);
                    mediaPlayer.start();
                }
            }
        });

        btnOms.setOnClickListener(btnOmss);
        btnPeratio.setOnClickListener(btnPeratios);
    }
    private View.OnClickListener btnOmss = new View.OnClickListener(){
        @Override
        public void onClick (View v){
            String s1=mEdtNetProfit.getText().toString();
            String s2=mEdtMoveSurplus.getText().toString();
            if(TextUtils.isEmpty(s1)||TextUtils.isEmpty(s2)){
                mEdtNetProfit.setError("Error");
                mEdtMoveSurplus.setError("Error");
            }
            else{
                Double netProfit = Double.parseDouble(mEdtNetProfit.getText().toString());
                Double moveSurplus = Double.parseDouble(mEdtMoveSurplus.getText().toString());
                if(netProfit!=0){
                    Double oms = (moveSurplus*100)/netProfit;
                    BigDecimal bd = new BigDecimal(oms);
                    bd = bd.setScale(2,BigDecimal.ROUND_HALF_UP);
                    String strSug = getString(R.string.oms);
                    strSug += bd;
                    strSug += " %";
                    mOms.setText(strSug);
                    String strSug1 = getString(R.string.xoms);
                    mOther.setText(strSug1);
                }
                else{
                    String strSug = getString(R.string.none);
                    mOms.setText(strSug);
                    String strSug1 = getString(R.string.xoms);
                    mOther.setText(strSug1);
                }
            }
        }
    };
    private View.OnClickListener btnPeratios = new View.OnClickListener(){
        @Override
        public void onClick (View v){
            String s1=mEdtPrice.getText().toString();
            String s2=mEdtEps.getText().toString();
            if(TextUtils.isEmpty(s1)||TextUtils.isEmpty(s2)){
                mEdtPrice.setError("Error");
                mEdtEps.setError("Error");
            }
            else{
                Double price = Double.parseDouble(mEdtPrice.getText().toString());
                Double eps = Double.parseDouble(mEdtEps.getText().toString());
                if(eps!=0){
                    Double peratio = price/eps;
                    BigDecimal bd = new BigDecimal(peratio);
                    bd = bd.setScale(2,BigDecimal.ROUND_HALF_UP);
                    String strSug = getString(R.string.peratio);
                    strSug += bd;
                    strSug += " 倍";
                    mPeratio.setText(strSug);
                    String strSug1 = getString(R.string.xperatio);
                    mOther.setText(strSug1);
                }
                else{
                    String strSug = getString(R.string.none);
                    mPeratio.setText(strSug);
                    String strSug1 = getString(R.string.xperatio);
                    mOther.setText(strSug1);
                }
            }
        }
    };
}