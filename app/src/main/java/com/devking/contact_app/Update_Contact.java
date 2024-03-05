package com.devking.contact_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Update_Contact extends AppCompatActivity {

    EditText name;
    EditText phn_number;
    EditText adhar_number;
    Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_contact);

        name = findViewById(R.id.name);
        phn_number = findViewById(R.id.phn_number);
        adhar_number = findViewById(R.id.adhar_number);
        update = findViewById(R.id.update);

        Intent intent =getIntent();
        ArrayList<String> contact_details = new ArrayList<>();
        contact_details = intent.getStringArrayListExtra("contact_details");

        name.setText(contact_details.get(0).toString());
        phn_number.setText(contact_details.get(1).toString());
        adhar_number.setText(contact_details.get(2).toString());

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });


    }

    private void update() {

        String url = "http://10.0.2.2:9000/api/";

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(url)
                .build();


        Api_call myapi = retrofit.create(Api_call.class);


        Call<Model_class> call = myapi.update_data(name.getText().toString(),phn_number.getText().toString(),adhar_number.getText().toString());

        call.enqueue(new Callback<Model_class>() {
            @Override
            public void onResponse(Call<Model_class> call, Response<Model_class> response) {

                name.setText("");
                phn_number.setText("");
                adhar_number.setText("");
                finish();

            }

            @Override
            public void onFailure(Call<Model_class> call, Throwable t) {

            }
        });



    }
}