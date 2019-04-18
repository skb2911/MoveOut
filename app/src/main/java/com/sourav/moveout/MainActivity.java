package com.sourav.moveout;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sourav.moveout.Adapters.ListOfCities;
import com.sourav.moveout.Models.City;
import com.sourav.moveout.Models.Currency;
import com.sourav.moveout.Models.DFTemperature;
import com.sourav.moveout.Models.JATemperature;
import com.sourav.moveout.Models.LocalWeather;
import com.sourav.moveout.Models.Location;
import com.sourav.moveout.Models.MMTemperature;
import com.sourav.moveout.Models.SNTemperature;
import com.sourav.moveout.Models.TemperatureC;
import com.sourav.moveout.Models.TemperatureF;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView listOfCitiesRecyclerView;
    ArrayList<String> listOfCities;
    EditText searchCity;

    ListOfCities listOfCitiesAdapter;

    String name;
    ArrayList<String> dontMiss;
    String about;
    Location location;
    String timeZone;
    ArrayList<Currency> listOfCurrencies;
    LocalWeather localWeather;
    ArrayList<String> thingsToDo;

    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseApp.initializeApp(this);

        firebaseDatabase = FirebaseDatabase.getInstance();



        /*
        name = "Hong Kong";
        dontMiss = new ArrayList<String>();
        dontMiss.add("Urban Adventure");
        dontMiss.add("Culinary Hotspot");
        dontMiss.add("Shopping Paradise");
        dontMiss.add("Iconic Landmarks");
        dontMiss.add("Bucket List Destination");
        dontMiss.add("Theme Park Fun");

        about = "The harbor city of Hong Kong is renowned for its spectacular skylines and scenic views.";

        location = new Location("22.3193° N","114.1694° E");

        timeZone = "GMT +08:00";

        Currency currency1 = new Currency("Hong Kong Dollar", "1 INR = 0.11 HKD");
        Currency currency2 = new Currency("Macau Pataca", "1 INR = 0.12 MOP");
        listOfCurrencies = new ArrayList<Currency>();
        listOfCurrencies.add(currency1);
        listOfCurrencies.add(currency2);

        TemperatureC dfTempC = new TemperatureC("20°","13°");
        TemperatureF dfTempF = new TemperatureF("68°","55°");
        DFTemperature dfTemperature = new DFTemperature(dfTempC, dfTempF);

        TemperatureC mmTempC = new TemperatureC("29°","17°");
        TemperatureF mmTempF = new TemperatureF("84°","63°");
        MMTemperature mmTemperature = new MMTemperature(mmTempC, mmTempF);

        TemperatureC jaTempC = new TemperatureC("31°","26°");
        TemperatureF jaTempF = new TemperatureF("88°","79°");
        JATemperature jaTemperature = new JATemperature(jaTempC, jaTempF);

        TemperatureC snTempC = new TemperatureC("29°","19°");
        TemperatureF snTempF = new TemperatureF("84°","66°");
        SNTemperature snTemperature = new SNTemperature(snTempC, snTempF);

        localWeather = new LocalWeather(dfTemperature, mmTemperature, jaTemperature, snTemperature);

        thingsToDo = new ArrayList<>();
        thingsToDo.add("Attraction & Shows");
        thingsToDo.add("Tours & Sightseeing");
        thingsToDo.add("Activities & Experience");
        thingsToDo.add("Transport & WiFi");

        City city = new City(name, dontMiss, about, location, timeZone, listOfCurrencies, localWeather, thingsToDo);




        DatabaseReference databaseReference = firebaseDatabase.getReference();

        databaseReference.child("App").child("Destinations").child("Hong Kong").setValue(city).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful())
                    Toast.makeText(MainActivity.this, "successfully uploaded", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
*/


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
