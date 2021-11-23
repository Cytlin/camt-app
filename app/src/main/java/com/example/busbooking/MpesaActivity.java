package com.example.busbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MpesaActivity extends AppCompatActivity {
    EditText phoneNumber;
    Button mpesaButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpesa);
        phoneNumber=findViewById(R.id.phoneNumber);
        mpesaButton=findViewById(R.id.mpesaButton);
        mpesaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SEND THE MESSAGE
                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                    if(checkSelfPermission(Manifest.permission.SEND_SMS)== PackageManager.PERMISSION_GRANTED){
                        sendsms();
                    }else{
                        requestPermissions(new String[]{Manifest.permission.SEND_SMS}, 1);
                    }
                }
                Intent intent= new Intent(getApplicationContext(),MyTrips.class);
                startActivity(intent);
            }
        });
    }
    private void sendsms(){
        String phoneNo= phoneNumber.getText().toString().trim();
        //String SMS= message.getText().toString().trim();
        String SMS= "Confirmed You have made your booking";

        try{
            //call the sms manager
            SmsManager smsManager= SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, SMS, null, null);
            Toast.makeText(this, "Message sent", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this,"failed to send the message", Toast.LENGTH_SHORT).show();
        }
    }
}