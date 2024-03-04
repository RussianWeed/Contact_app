package com.devking.contact_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Create_Contact extends AppCompatActivity {
    EditText name;
    EditText phn_number;
    EditText adhar_number;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);

        name = findViewById(R.id.name);
        phn_number = findViewById(R.id.phn_number);
        adhar_number = findViewById(R.id.adhar_number);
        add = findViewById(R.id.add);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add_contact();
            }
        });


    }

    private void add_contact() {
        String url = "http://10.0.2.2:9000/api/";

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(url)
                .build();


        Api_call myapi = retrofit.create(Api_call.class);


        Call<Model_class> call = myapi.add_data(name.getText().toString(),phn_number.getText().toString(),adhar_number.getText().toString());

        call.enqueue(new Callback<Model_class>() {
            @Override
            public void onResponse(Call<Model_class> call, Response<Model_class> response) {

                name.setText("");
                phn_number.setText("");
                adhar_number.setText("");
            }

            @Override
            public void onFailure(Call<Model_class> call, Throwable t) {

            }
        });

    }
}