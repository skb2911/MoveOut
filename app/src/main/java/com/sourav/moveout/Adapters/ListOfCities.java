package com.sourav.moveout.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import android.widget.Toast;


import com.sourav.moveout.CityActivity;
import com.sourav.moveout.R;

import java.util.ArrayList;

public class ListOfCities extends RecyclerView.Adapter<ListOfCities.ViewHolder> {

    RecyclerView recyclerView;
    Context context;
    ArrayList<String> listOfCities;

    public ListOfCities(RecyclerView recyclerView, Context context, ArrayList<String> listOfCities) {
        this.recyclerView = recyclerView;
        this.context = context;
        this.listOfCities = listOfCities;
    }

    public ListOfCities() {
    }

    public void filterList(ArrayList<String> filterList){
        listOfCities = filterList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout_item_cities, viewGroup, false);
        return new ListOfCities.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {

        viewHolder.cityName.setText(listOfCities.get(i));

        //Picasso.get().load(R.drawable.hongkong).into(holder.picImage);

        if(listOfCities.get(i).toLowerCase().equals("hong kong")){
            viewHolder.cityImage.setImageResource(R.drawable.hongkong);
        }
        else if (listOfCities.get(i).toLowerCase().equals("macau")){
            viewHolder.cityImage.setImageResource(R.drawable.macau);
        }else if (listOfCities.get(i).toLowerCase().equals("singapore")){
            viewHolder.cityImage.setImageResource(R.drawable.singapore);
        }else if (listOfCities.get(i).toLowerCase().equals("seoul")){
            viewHolder.cityImage.setImageResource(R.drawable.seoul);
        }else if (listOfCities.get(i).toLowerCase().equals("beijing")){
            viewHolder.cityImage.setImageResource(R.drawable.beijing);
        }else if (listOfCities.get(i).toLowerCase().equals("tokyo")){
            viewHolder.cityImage.setImageResource(R.drawable.tokyo);
        }else if (listOfCities.get(i).toLowerCase().equals("osaka")){
            viewHolder.cityImage.setImageResource(R.drawable.osaka);
        }else if (listOfCities.get(i).toLowerCase().equals("jr pass")){
            viewHolder.cityImage.setImageResource(R.drawable.jrpass);
        }else if (listOfCities.get(i).toLowerCase().equals("okinawa")){
            viewHolder.cityImage.setImageResource(R.drawable.okinawa);
        }else if (listOfCities.get(i).toLowerCase().equals("taipei")){
            viewHolder.cityImage.setImageResource(R.drawable.taipei);
        }else {
            Toast.makeText(context, "Error occurred", Toast.LENGTH_SHORT).show();
        }

        viewHolder.cityImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CityActivity.class);
                intent.putExtra("City Name", listOfCities.get(i));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listOfCities.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView cityImage;
        TextView cityName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cityImage = itemView.findViewById(R.id.cityImage);
            cityName = itemView.findViewById(R.id.cityName);
        }
    }
}
