package com.financialstatement;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;
import android.content.*;
import android.net.*;
import android.media.*;

public class MainActivity extends Activity
{
    Button btnEfficiency,btnFluidity,btnStructure,btnSafeMargin,btnValuePrice,btnOthers;
    private MediaPlayer playSong;
    Button btnPlay,btnPause,btnUser,btnNote;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEfficiency = findViewById(R.id.btnEfficiency);
        btnFluidity = findViewById(R.id.btnFluidity);
        btnStructure = findViewById(R.id.btnStructure);
        btnSafeMargin = findViewById(R.id.btnSafeMargin);
        btnValuePrice =  findViewById(R.id.btnValuePrice);
        btnOthers =  findViewById(R.id.btnOthers);

        btnPlay= findViewById(R.id.play);
        btnPause = findViewById(R.id.pause);
        playSong = MediaPlayer.create(this,R.raw.endless);
        playSong.start();

        btnUser = findViewById(R.id.userInstruction);
        btnNote = findViewById(R.id.note);

        btnPlay.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                playSong.start();
            }
        });
        btnPause.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                playSong.pause();
            }
        });
        btnUser.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,userInstruction.class);
                startActivity(intent);
            }
        });
        btnNote.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,userInstruction.class);
                startActivity(intent);
            }
        });
        btnEfficiency.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,efficiency.class);
                startActivity(intent);
            }
        });
        btnFluidity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,fluidity.class);
                startActivity(intent);
            }
        });
        btnStructure.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,structure.class);
                startActivity(intent);
            }
        });
        btnSafeMargin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,safemargin.class);
                startActivity(intent);
            }
        });
        btnValuePrice.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,valueprice.class);
                startActivity(intent);
            }
        });
        btnOthers.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,others.class);
                startActivity(intent);
            }
        });
    }
    public void jump1(View view){
        Uri uri = Uri.parse("http://mops.twse.com.tw");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }
    public void jump2(View view){
        Uri uri = Uri.parse("http://www.cnbc.com");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }
    public void jump3(View view){
        Uri uri = Uri.parse("http://finviz.com");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }
}