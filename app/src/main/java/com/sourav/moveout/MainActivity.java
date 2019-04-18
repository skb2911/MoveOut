package com.sourav.moveout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.sourav.moveout.Adapters.ListOfCities;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView listOfCitiesRecyclerView;
    ArrayList<String> listOfCities;
    EditText searchCity;

    ListOfCities listOfCitiesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listOfCitiesRecyclerView = findViewById(R.id.recyclerViewListOfCities);
        searchCity = findViewById(R.id.searchCity);
        searchCity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(editable.toString());
            }
        });

        listOfCities = new ArrayList<>();
        listOfCities.add("Hong Kong");
        listOfCities.add("Macau");
        listOfCities.add("Singapore");
        listOfCities.add("Seoul");
        listOfCities.add("Beijing");
        listOfCities.add("Tokyo");
        listOfCities.add("Osaka");
        listOfCities.add("JR Pass");
        listOfCities.add("Okinawa");
        listOfCities.add("Taipei");


        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        //        recyclerViewVideoCategories.setLayoutManager(linearLayoutManager);
        //        AdapterForVideoCategories adapterForVideoCategories = new AdapterForVideoCategories(recyclerViewVideoCategories, getContext(),listOfNamesOfVideoCategories );
        //        recyclerViewVideoCategories.setAdapter(adapterForVideoCategories);

        final GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this,2);
        listOfCitiesRecyclerView.setLayoutManager(gridLayoutManager);
        listOfCitiesAdapter = new ListOfCities(listOfCitiesRecyclerView, MainActivity.this, listOfCities);
        listOfCitiesRecyclerView.setAdapter(listOfCitiesAdapter);

    }

    private void filter(String text) {
        ArrayList<String> filteredList = new ArrayList<>();
        for(String city: listOfCities){
            if(city.toString().toLowerCase().trim().contains(text.toLowerCase())){
                filteredList.add(city);
            }
        }

        listOfCitiesAdapter.filterList(filteredList);
    }


}
