package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText stock, quantity, date, price, valuation;
    Button insert, view, delete;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stock = findViewById(R.id.stock);
        quantity= findViewById(R.id.quantity);
        date = findViewById(R.id.date);
        price = findViewById(R.id.price);
        valuation = findViewById(R.id.valuation);
        insert = findViewById(R.id.btnInsert);
        view = findViewById(R.id.btnView);
        delete = findViewById(R.id.btnDelete);
        DB = new DBHelper(this);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Userlist.class));
            }
        });

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stockTXT = stock.getText().toString();
                String quantityTXT = quantity.getText().toString();
                String dateTXT = date.getText().toString();
                String priceTXT = price.getText().toString();
                String valuationTXT = valuation.getText().toString();
                Boolean checkinsertdata  = DB.insertuserdata(stockTXT, quantityTXT, dateTXT,priceTXT,valuationTXT);
                if(checkinsertdata==true)
                {
                    Toast.makeText(MainActivity.this, "New Data Inserted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "New Data Not Inserted", Toast.LENGTH_SHORT).show();
                }

            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stockTXT = stock.getText().toString();

                Boolean checkdeletedata  = DB.deleteuserdata(stockTXT);
                if(checkdeletedata==true)
                {
                    Toast.makeText(MainActivity.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}