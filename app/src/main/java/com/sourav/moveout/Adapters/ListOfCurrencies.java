package com.sourav.moveout.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sourav.moveout.R;

import java.util.ArrayList;
import java.util.Currency;

public class ListOfCurrencies extends RecyclerView.Adapter<ListOfCurrencies.ViewHolder> {
    RecyclerView recyclerView;
    Context context;
    ArrayList<String> arrayListCurrencyName, arrayListConversion;

    public ListOfCurrencies(RecyclerView recyclerView, Context context, ArrayList<String> arrayListCurrencyName, ArrayList<String> arrayListConversion) {
        this.recyclerView = recyclerView;
        this.context = context;
        this.arrayListCurrencyName = arrayListCurrencyName;
        this.arrayListConversion = arrayListConversion;
    }

    public void update (String currencyName, String conversion){
        arrayListCurrencyName.add(currencyName);
        arrayListConversion.add(conversion);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout_currency, viewGroup, false);
        return new ListOfCurrencies.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.currencyName.setText(arrayListCurrencyName.get(i));
        viewHolder.conversion.setText(arrayListConversion.get(i));

    }

    @Override
    public int getItemCount() {
        return arrayListCurrencyName.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView currencyName, conversion;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            currencyName = itemView.findViewById(R.id.currencyName);
            conversion = itemView.findViewById(R.id.conversion);
        }
    }
}
