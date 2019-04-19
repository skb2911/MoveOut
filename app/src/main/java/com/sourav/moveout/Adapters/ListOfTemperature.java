package com.sourav.moveout.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.sourav.moveout.R;

import java.util.ArrayList;

public class ListOfTemperature extends RecyclerView.Adapter<ListOfTemperature.ViewHolder> {

    RecyclerView recyclerView;
    Context context;
    Button celsius, fahrenheit;
    ArrayList<String> arrayListDuration;
    ArrayList<String> arrayListMinC;
    ArrayList<String> arrayListMaxC;
    ArrayList<String> arrayListMinF;
    ArrayList<String> arrayListMaxF;

    public ListOfTemperature(RecyclerView recyclerView, Context context, Button celsius, Button fahrenheit, ArrayList<String> arrayListDuration, ArrayList<String> arrayListMinC, ArrayList<String> arrayListMaxC, ArrayList<String> arrayListMinF, ArrayList<String> arrayListMaxF) {
        this.recyclerView = recyclerView;
        this.context = context;
        this.celsius = celsius;
        this.fahrenheit = fahrenheit;
        this.arrayListDuration = arrayListDuration;
        this.arrayListMinC = arrayListMinC;
        this.arrayListMaxC = arrayListMaxC;
        this.arrayListMinF = arrayListMinF;
        this.arrayListMaxF = arrayListMaxF;
    }

    public void update(String duration, String maxC, String minC, String maxF, String minF){
        arrayListDuration.add(duration);
        arrayListMaxC.add(maxC);
        arrayListMinC.add(minC);
        arrayListMaxF.add(maxF);
        arrayListMinF.add(minF);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout_temperature, viewGroup, false);
        return new ListOfTemperature.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

        //Toast.makeText(context, arrayListDuration.get(i), Toast.LENGTH_SHORT).show();
        viewHolder.durationTV.setText(arrayListDuration.get(i));

        viewHolder.maxTV.setText(arrayListMaxF.get(i) + "F");
        viewHolder.minTV.setText(arrayListMinF.get(i) + "F");

        celsius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fahrenheit.setVisibility(View.VISIBLE);
                celsius.setVisibility(View.INVISIBLE);
                for(int j=0; j<arrayListDuration.size();j++){
                    viewHolder.maxTV.setText(arrayListMaxC.get(j) + "C");
                    viewHolder.minTV.setText(arrayListMinC.get(j) + "C");
                }
//                viewHolder.maxTV.setText(arrayListMaxC.get(i) + "C");
//                viewHolder.minTV.setText(arrayListMinC.get(i) + "C");
            }
        });

        fahrenheit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                celsius.setVisibility(View.VISIBLE);
                fahrenheit.setVisibility(View.INVISIBLE);
                for(int j=0; j<arrayListDuration.size();j++){
                    viewHolder.maxTV.setText(arrayListMaxF.get(i) + "F");
                    viewHolder.minTV.setText(arrayListMinF.get(i) + "F");
                }
//                viewHolder.maxTV.setText(arrayListMaxF.get(i) + "F");
//                viewHolder.minTV.setText(arrayListMinF.get(i) + "F");
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayListDuration.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView durationTV, maxTV, minTV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            durationTV = itemView.findViewById(R.id.duration);
            maxTV = itemView.findViewById(R.id.max);
            minTV = itemView.findViewById(R.id.min);
        }
    }
}
