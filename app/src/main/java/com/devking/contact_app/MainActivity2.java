package com.devking.contact_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView adhar = findViewById(R.id.adhar_nummber);
        TextView name = findViewById(R.id.name);
        TextView phn_number = findViewById(R.id.phn_number);


        Intent intent = getIntent();

        // Retrieve the ArrayList<String> from the Intent
        ArrayList<String> contactDetail = intent.getStringArrayListExtra("contact_details");

        if (contactDetail != null && contactDetail.size() > 0) {

            String Name = contactDetail.get(0);
            String phnnumber = contactDetail.get(2);
            String adharCardNumber = contactDetail.get(1);

            adhar.append("Adhhaar-Number : "+adharCardNumber);
            name.append("Name : "+ Name);
            phn_number.append("Phone-Number : "+phnnumber);
        }
    }
}
