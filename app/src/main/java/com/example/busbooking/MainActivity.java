package com.example.busbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Calendar;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {
    EditText date,seats;
    Button button;
    DatePickerDialog.OnDateSetListener mDateSetListener;
    Spinner route,time;
    String[] routeString= new String[] {"Select Route","CBD to KASARANI", "CBD to JUJA", "CBD to ROYSAMBU", "CBD to KAHAWASUKARI", "KASARANI to CBD", "JUJA to CBD", "ROYSAMBU to CBD"};
    String[] timeString= new String[] {"Select Time","7:00am", "9:00am", "11:00am", "1:00pm", "3:00pm", "5:00pm", "7:00pm"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        date=findViewById(R.id.date);
        route=findViewById(R.id.route);
        time=findViewById(R.id.time);
        seats=findViewById(R.id.seats);
        button=findViewById(R.id.button);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                //declares the pop up dialog box
                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String setdate = month + "/" + day + "/" + year;
                date.setText(setdate);
            }
        };

        //route dropdown Adapter
        ArrayAdapter<String> routeAdapter=new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,routeString);
        routeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        route.setAdapter(routeAdapter);

        //time dropdown Adapter
        ArrayAdapter<String> timeAdapter=new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,timeString);
        timeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        time.setAdapter(timeAdapter);




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numberofSeats= seats.getText().toString().trim();
                int finalSeats=Integer.parseInt(numberofSeats);
                int totalCosts= finalSeats*100;
                //totalcost.setText(totalCosts);
                String totalCostString =String.valueOf(totalCosts);
                Bundle bundle=new Bundle();
                bundle.putString("costs",totalCostString);
                Intent intent= new Intent(getApplicationContext(),PaymentActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });

    }


}