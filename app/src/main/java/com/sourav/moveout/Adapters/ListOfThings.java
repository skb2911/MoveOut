package com.sourav.moveout.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sourav.moveout.R;

import java.util.ArrayList;

public class ListOfThings extends RecyclerView.Adapter<ListOfThings.ViewHolder> {

    RecyclerView recyclerViewListOfThings;
    Context context;
    ArrayList<String> arrayListThingsToDo;

    public ListOfThings(RecyclerView recyclerViewListOfThings, Context context, ArrayList<String> arrayListThingsToDo) {
        this.recyclerViewListOfThings = recyclerViewListOfThings;
        this.context = context;
        this.arrayListThingsToDo = arrayListThingsToDo;
    }

    public ListOfThings() {
    }

    public void update(String things){

        arrayListThingsToDo.add(things);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout_item_things_to_do, viewGroup, false);
        return new ListOfThings.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.thing.setText(arrayListThingsToDo.get(i));

    }

    @Override
    public int getItemCount() {
        return arrayListThingsToDo.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView thing;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            thing = itemView.findViewById(R.id.thingsName);
        }
    }
}
