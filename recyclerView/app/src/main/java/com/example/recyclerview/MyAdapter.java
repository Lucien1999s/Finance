package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private ArrayList stock_id, quantity_id, date_id, price_id, valuation_id;

    public MyAdapter(Context context, ArrayList stock_id, ArrayList quantity_id, ArrayList date_id,ArrayList price_id,ArrayList valuation_id) {
        this.context = context;
        this.stock_id = stock_id;
        this.quantity_id = quantity_id;
        this.date_id = date_id;
        this.price_id = price_id;
        this.valuation_id = valuation_id;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.stock_id.setText(String.valueOf(stock_id.get(position)));
        holder.quantity_id.setText(String.valueOf(quantity_id.get(position)));
        holder.date_id.setText(String.valueOf(date_id.get(position)));
        holder.price_id.setText(String.valueOf(price_id.get(position)));
        holder.valuation_id.setText(String.valueOf(valuation_id.get(position)));
    }

    @Override
    public int getItemCount() {
        return stock_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView stock_id, quantity_id, date_id, price_id, valuation_id;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            stock_id = itemView.findViewById(R.id.textstock);
            quantity_id = itemView.findViewById(R.id.textquantity);
            date_id = itemView.findViewById(R.id.textdate);
            price_id = itemView.findViewById(R.id.textprice);
            valuation_id = itemView.findViewById(R.id.textvaluation);
        }
    }
}
