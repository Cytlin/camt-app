package com.example.busbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PaymentActivity extends AppCompatActivity {
    TextView mop, showCost, showCost2;
    Button mpesa,card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        mop=findViewById(R.id.mop);
        mpesa=findViewById(R.id.mpesa);
        card=findViewById(R.id.card);
        showCost=findViewById(R.id.showCost);
        showCost2=findViewById(R.id.showCost2);

        Bundle bundle= getIntent().getExtras();
        if(bundle!=null){
            String totalCosts=bundle.getString("costs");
            showCost2.setText(totalCosts);
        }


        mpesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(getApplicationContext(),MpesaActivity.class);
                startActivity(intent);
            }
        });

        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(getApplicationContext(),CardActivity.class);
                startActivity(intent);
            }
        });
    }
}