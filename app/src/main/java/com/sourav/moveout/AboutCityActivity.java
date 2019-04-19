package com.sourav.moveout;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import com.sourav.moveout.Adapters.ListOfCurrencies;
import com.sourav.moveout.Adapters.ListOfThings;
import com.sourav.moveout.Models.City;
import com.sourav.moveout.Models.Currency;

import java.util.ArrayList;

public class AboutCityActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;

    TextView cityNameTextView, dontMissTextView, aboutCityTextView, timeZoneTextView, maxDF, minDF, maxMM, minMM, maxJA, minJA, maxSN, minSN;
    RecyclerView currenciesRecyclerView;
    Button celsius, fahrenheit;
    int tempType =2;


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

                Log.d("City", dataSnapshot.toString());

                String name = dataSnapshot.child("name").getValue(String.class);
                cityNameTextView.setText(name);

                String about = dataSnapshot.child("about").getValue(String.class);
                aboutCityTextView.setText(about);

                String timeZone = dataSnapshot.child("timeZone").getValue(String.class);
                timeZoneTextView.setText(timeZone);

                ArrayList<Currency> listOfCurrencies = dataSnapshot.child("listOfCurrencies").getValue(s);

                ArrayList<String> dontMiss = dataSnapshot.child("dontMiss").getValue(t);

                City city = dataSnapshot.getValue(City.class);

                for(int i=0; i<listOfCurrencies.size();i++){
                    ((ListOfCurrencies)currenciesRecyclerView.getAdapter()).update(listOfCurrencies.get(i).getCurrencyName(), listOfCurrencies.get(i).getCurrencyConversion());
                }

                String dontMissList = "Don't Miss: "+ dontMiss.get(0);
                for(int i=1; i<dontMiss.size();i++){
                    dontMissList = dontMissList.concat(" - ").concat(dontMiss.get(i));
                }
                dontMissTextView.setText(dontMissList);

                final String maxCDF = dataSnapshot.child("localWeather").child("dfTemperature").child("temperatureC").child("max").getValue(String.class) + "C";
                final String minCDF = dataSnapshot.child("localWeather").child("dfTemperature").child("temperatureC").child("min").getValue(String.class) + "C";
                final String maxCMM = dataSnapshot.child("localWeather").child("mmTemperature").child("temperatureC").child("max").getValue(String.class) + "C";
                final String minCMM = dataSnapshot.child("localWeather").child("mmTemperature").child("temperatureC").child("min").getValue(String.class) + "C";
                final String maxCJA = dataSnapshot.child("localWeather").child("jaTemperature").child("temperatureC").child("max").getValue(String.class) + "C";
                final String minCJA = dataSnapshot.child("localWeather").child("jaTemperature").child("temperatureC").child("min").getValue(String.class) + "C";
                final String maxCSN = dataSnapshot.child("localWeather").child("snTemperature").child("temperatureC").child("max").getValue(String.class) + "C";
                final String minCSN = dataSnapshot.child("localWeather").child("snTemperature").child("temperatureC").child("min").getValue(String.class) + "C";

                final String maxFDF = dataSnapshot.child("localWeather").child("dfTemperature").child("temperatureF").child("max").getValue(String.class) + "F";
                final String minFDF = dataSnapshot.child("localWeather").child("dfTemperature").child("temperatureF").child("min").getValue(String.class) + "F";
                final String maxFMM = dataSnapshot.child("localWeather").child("mmTemperature").child("temperatureF").child("max").getValue(String.class) + "F";
                final String minFMM = dataSnapshot.child("localWeather").child("mmTemperature").child("temperatureF").child("min").getValue(String.class) + "F";
                final String maxFJA = dataSnapshot.child("localWeather").child("jaTemperature").child("temperatureF").child("max").getValue(String.class) + "F";
                final String minFJA = dataSnapshot.child("localWeather").child("jaTemperature").child("temperatureF").child("min").getValue(String.class) + "F";
                final String maxFSN = dataSnapshot.child("localWeather").child("snTemperature").child("temperatureF").child("max").getValue(String.class) + "F";
                final String minFSN = dataSnapshot.child("localWeather").child("snTemperature").child("temperatureF").child("min").getValue(String.class) + "F";


                maxDF.setText(maxFDF);
                minDF.setText(minFDF);
                maxMM.setText(maxFMM);
                minMM.setText(minFMM);
                maxJA.setText(maxFJA);
                minJA.setText(minFJA);
                maxSN.setText(maxFSN);
                minSN.setText(minFSN);

                celsius.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        fahrenheit.setVisibility(View.VISIBLE);
                        celsius.setVisibility(View.INVISIBLE);
                        tempType = 1;
                        maxDF.setText(maxCDF);
                        minDF.setText(minCDF);
                        maxMM.setText(maxCMM);
                        minMM.setText(minCMM);
                        maxJA.setText(maxCJA);
                        minJA.setText(minCJA);
                        maxSN.setText(maxCSN);
                        minSN.setText(minCSN);
                    }
                });

                fahrenheit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        celsius.setVisibility(View.VISIBLE);
                        fahrenheit.setVisibility(View.INVISIBLE);
                        tempType = 2;
                        maxDF.setText(maxFDF);
                        minDF.setText(minFDF);
                        maxMM.setText(maxFMM);
                        minMM.setText(minFMM);
                        maxJA.setText(maxFJA);
                        minJA.setText(minFJA);
                        maxSN.setText(maxFSN);
                        minSN.setText(minFSN);
                    }
                });
//                if(tempType == 1){
//                    maxDF.setText(maxCDF);
//                    minDF.setText(minCDF);
//                    maxMM.setText(maxCMM);
//                    minMM.setText(minCMM);
//                    maxJA.setText(maxCJA);
//                    minJA.setText(minCJA);
//                    maxSN.setText(maxCSN);
//                    minSN.setText(minCSN);
//                }
//                else if(tempType == 2){
//                    maxDF.setText(maxFDF);
//                    minDF.setText(minFDF);
//                    maxMM.setText(maxFMM);
//                    minMM.setText(minFMM);
//                    maxJA.setText(maxFJA);
//                    minJA.setText(minFJA);
//                    maxSN.setText(maxFSN);
//                    minSN.setText(minFSN);
//                }
//                else {
//                    Toast.makeText(AboutCityActivity.this, "Error in temperature", Toast.LENGTH_SHORT).show();
//                }

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
        //adapterForRecordsList.notifyDataSetChanged();
        currenciesRecyclerView.setAdapter(listOfCurrencies);
    }

    private void initials() {
        cityNameTextView = findViewById(R.id.cityName); //
        dontMissTextView = findViewById(R.id.dontMissList); //
        aboutCityTextView = findViewById(R.id.aboutCityTextView); //
        timeZoneTextView = findViewById(R.id.timeZoneTextView); //

        celsius = findViewById(R.id.celsiusButton);
        fahrenheit = findViewById(R.id.fahrenheitButton);

        currenciesRecyclerView = findViewById(R.id.recyclerViewCurrencies); //

        maxDF = findViewById(R.id.maxDF);
        minDF = findViewById(R.id.minDF);
        maxMM = findViewById(R.id.maxMM);
        minMM = findViewById(R.id.minMM);
        maxJA = findViewById(R.id.maxJA);
        minJA = findViewById(R.id.minJA);
        maxSN = findViewById(R.id.maxSN);
        minSN = findViewById(R.id.minSN);
    }
}
