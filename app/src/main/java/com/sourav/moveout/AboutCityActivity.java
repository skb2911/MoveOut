package com.sourav.moveout;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.sourav.moveout.Adapters.ListOfCities;
import com.sourav.moveout.Adapters.ListOfCurrencies;
import com.sourav.moveout.Adapters.ListOfTemperature;
import com.sourav.moveout.Adapters.ListOfThings;
import com.sourav.moveout.Models.City;
import com.sourav.moveout.Models.Currency;
import com.sourav.moveout.Models.Temperature;

import java.util.ArrayList;

public class AboutCityActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;

    TextView cityNameTextView, dontMissTextView, aboutCityTextView, timeZoneTextView;
    RecyclerView currenciesRecyclerView, temperatureRecyclerView;
    Button celsius, fahrenheit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_city);

        initials();

        final String cityName = getIntent().getStringExtra("City Name");

        firebaseDatabase = FirebaseDatabase.getInstance();
        final DatabaseReference databaseReference = firebaseDatabase.getReference();

        databaseReference.child("App").child("Destinations").child(cityName).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                GenericTypeIndicator<ArrayList<String>> t = new GenericTypeIndicator<ArrayList<String>>() {};
                GenericTypeIndicator<ArrayList<Currency>> s = new GenericTypeIndicator<ArrayList<Currency>>() {};
                GenericTypeIndicator<ArrayList<Temperature>> u = new GenericTypeIndicator<ArrayList<Temperature>>() {};

                String name = dataSnapshot.child("name").getValue(String.class);
                cityNameTextView.setText(name);

                String about = dataSnapshot.child("about").getValue(String.class);
                aboutCityTextView.setText(about);

                String timeZone = dataSnapshot.child("timeZone").getValue(String.class);
                timeZoneTextView.setText(timeZone);

                ArrayList<Currency> listOfCurrencies = dataSnapshot.child("listOfCurrencies").getValue(s);

                ArrayList<String> dontMiss = dataSnapshot.child("dontMiss").getValue(t);

                ArrayList<Temperature> listOfTemperatures = dataSnapshot.child("listOfTemperature").getValue(u);

//                City city = dataSnapshot.getValue(City.class);

                for(int i=0; i<listOfCurrencies.size();i++){
                    ((ListOfCurrencies)currenciesRecyclerView.getAdapter()).update(listOfCurrencies.get(i).getCurrencyName(), listOfCurrencies.get(i).getCurrencyConversion());
                }

                for(int i=0; i<listOfTemperatures.size();i++){
                    ((ListOfTemperature)temperatureRecyclerView.getAdapter()).update(listOfTemperatures.get(i).getDuration(),listOfTemperatures.get(i).getTemperatureC().getMax(),listOfTemperatures.get(i).getTemperatureC().getMin(),listOfTemperatures.get(i).getTemperatureF().getMax(), listOfTemperatures.get(i).getTemperatureF().getMin());
                }


                String dontMissList = "Don't Miss: "+ dontMiss.get(0);
                for(int i=1; i<dontMiss.size();i++){
                    dontMissList = dontMissList.concat(" - ").concat(dontMiss.get(i));
                }
                dontMissTextView.setText(dontMissList);


//                for (DataSnapshot postSnapshot : dataSnapshot.child("thingsToDo").getChildren()) {
//                    //Getting the data from snapshot
//                    String thing= postSnapshot.getValue(String.class);
//                    Log.d("things",thing);
//                    Toast.makeText(CityActivity.this, thing, Toast.LENGTH_SHORT).show();
//                    ((ListOfThings)recyclerViewListOfThings.getAdapter()).update(thing);
//                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        currenciesRecyclerView.setLayoutManager(new LinearLayoutManager(AboutCityActivity.this));
        ListOfCurrencies listOfCurrencies = new ListOfCurrencies(currenciesRecyclerView, AboutCityActivity.this, new ArrayList<String>(), new ArrayList<String>() );
        currenciesRecyclerView.setAdapter(listOfCurrencies);

        final GridLayoutManager gridLayoutManager = new GridLayoutManager(AboutCityActivity.this,2);
        temperatureRecyclerView.setLayoutManager(gridLayoutManager);
        ListOfTemperature listOfTemperature = new ListOfTemperature(temperatureRecyclerView, AboutCityActivity.this, celsius, fahrenheit, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>());
        temperatureRecyclerView.setAdapter(listOfTemperature);
    }

    private void initials() {
        cityNameTextView = findViewById(R.id.cityName); //
        dontMissTextView = findViewById(R.id.dontMissList); //
        aboutCityTextView = findViewById(R.id.aboutCityTextView); //
        timeZoneTextView = findViewById(R.id.timeZoneTextView); //

        celsius = findViewById(R.id.celsiusButton);
        fahrenheit = findViewById(R.id.fahrenheitButton);

        currenciesRecyclerView = findViewById(R.id.recyclerViewCurrencies); //
        temperatureRecyclerView = findViewById(R.id.temperatureRecyclerView);
    }
}
