package com.example.busbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CardActivity extends AppCompatActivity {
    EditText cardNumber, expiryDate, cardHolderName;
    Button cardButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        cardNumber=findViewById(R.id.cardNumber);
        expiryDate=findViewById(R.id.expiryDate);
        cardHolderName=findViewById(R.id.cardHolderName);
        cardButton=findViewById(R.id.cardButton);
        cardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),MyTrips.class);
                startActivity(intent);
            }
        });
    }
}