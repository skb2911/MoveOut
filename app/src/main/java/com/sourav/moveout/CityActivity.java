package com.sourav.moveout;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.sourav.moveout.Adapters.ListOfThings;
import com.sourav.moveout.Models.City;
import com.sourav.moveout.Models.Location;

import java.util.ArrayList;
import java.util.List;

public class CityActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;

    RecyclerView recyclerViewListOfThings;

    TextView dontMissTextView, cityNameTextView, aboutCity;
    RelativeLayout layout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

        firebaseDatabase = FirebaseDatabase.getInstance();
        final DatabaseReference databaseReference = firebaseDatabase.getReference();

        recyclerViewListOfThings = findViewById(R.id.recyclerViewThingsToDo);
        dontMissTextView = findViewById(R.id.dontMiss);
        cityNameTextView = findViewById(R.id.cityName);
        layout = findViewById(R.id.layout);
        aboutCity = findViewById(R.id.aboutCity);

        final String cityName = getIntent().getStringExtra("City Name");
        if(cityName.toLowerCase().equals("hong kong")){
            layout.setBackgroundResource(R.drawable.hongkong);
        }
        else if (cityName.toLowerCase().equals("macau")){
            layout.setBackgroundResource(R.drawable.macau);
        }else if (cityName.toLowerCase().equals("singapore")){
            layout.setBackgroundResource(R.drawable.singapore);
        }else if (cityName.toLowerCase().equals("seoul")){
            layout.setBackgroundResource(R.drawable.seoul);
        }else if (cityName.toLowerCase().equals("beijing")){
            layout.setBackgroundResource(R.drawable.beijing);
        }else if (cityName.toLowerCase().equals("tokyo")){
            layout.setBackgroundResource(R.drawable.tokyo);
        }else if (cityName.toLowerCase().equals("osaka")){
            layout.setBackgroundResource(R.drawable.osaka);
        }else if (cityName.toLowerCase().equals("jr pass")){
            layout.setBackgroundResource(R.drawable.jrpass);
        }else if (cityName.toLowerCase().equals("okinawa")){
            layout.setBackgroundResource(R.drawable.okinawa);
        }else if (cityName.toLowerCase().equals("taipei")){
            layout.setBackgroundResource(R.drawable.taipei);
        }else {
            Toast.makeText(this, "Error occurred", Toast.LENGTH_SHORT).show();
        }

        cityNameTextView.setText(cityName);

        databaseReference.child("App").child("Destinations").child(cityName).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                GenericTypeIndicator<ArrayList<String>> t = new GenericTypeIndicator<ArrayList<String>>() {};

                Log.d("City", dataSnapshot.toString());

                String name = dataSnapshot.child("name").getValue(String.class);

                ArrayList<String> thingsToDo = dataSnapshot.child("thingsToDo").getValue(t);

                ArrayList<String> dontMiss = dataSnapshot.child("dontMiss").getValue(t);


                City city = dataSnapshot.getValue(City.class);

//                ArrayList things = dataSnapshot.child("thingsToDo").getValue(ArrayList.class);
                Log.d("ths",city.toString());

                for(int i=0; i<thingsToDo.size();i++){
                    ((ListOfThings)recyclerViewListOfThings.getAdapter()).update(thingsToDo.get(i));

                }

                String dontMissList="Don't Miss: "+ dontMiss.get(0);
                for(int i=1; i<dontMiss.size();i++){
                    dontMissList = dontMissList.concat(" | ").concat(dontMiss.get(i));
                }
                //Toast.makeText(CityActivity.this, dontMissList, Toast.LENGTH_SHORT).show();
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


        recyclerViewListOfThings.setLayoutManager(new LinearLayoutManager(CityActivity.this));
        ListOfThings listOfThings = new ListOfThings(recyclerViewListOfThings, CityActivity.this, new ArrayList<String>() );
        //adapterForRecordsList.notifyDataSetChanged();
        recyclerViewListOfThings.setAdapter(listOfThings);

        aboutCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aboutCItyIntent = new Intent(CityActivity.this, AboutCityActivity.class);
                aboutCItyIntent.putExtra("City Name", cityName);
                startActivity(aboutCItyIntent);
            }
        });
    }
}
