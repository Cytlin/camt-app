package com.example.busbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyTrips extends AppCompatActivity {
    ArrayList<String> tripsArray = new ArrayList<String>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_trips);
        Bundle bundle = getIntent().getExtras();
        listView= findViewById(listView);

        if (bundle != null) {
            String date = bundle.getString("date");
            String route = bundle.getString("route");
            String time = bundle.getString("time");
            String seats = bundle.getString("seats");

            if (tripsArray.contains(date || route || time||seats)){
                Toast.makeText(MyTrips.this, "Booking already exists", Toast.LENGTH_LONG).show();
            }
            else if (tripsArray.contains(date==null && route==null && time==null && seats==null)){
                Toast.makeText(MyTrips.this, "No bookings yet", Toast.LENGTH_LONG).show();
            }
            else{
                tripsArray.add(date && route && time && seats);
                ArrayAdapter<String> myTripsAdapter = new ArrayAdapter<String>(MyTrips.this,android.R.layout.simple_list_item_1, tripsArray);
                show.setAdapter(myTripsAdapter);


            }

        }


    }
}