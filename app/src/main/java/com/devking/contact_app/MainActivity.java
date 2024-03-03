package com.devking.contact_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView text_view = findViewById(R.id.tv);

        String url = "http://10.0.2.2:9000/api/";

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(url)
                .build();



        Api_call call = retrofit.create(Api_call.class);

        Call<List<Model_class>> contact_list = call.getcontactlist();

        contact_list.enqueue(new Callback<List<Model_class>>() {
            @Override
            public void onResponse(Call<List<Model_class>> call, Response<List<Model_class>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Model_class> data = response.body();
                    for (Model_class model : data) {
                        text_view.append("Name: " + model.getName() + "\n");
                    }
                } else {
                    Log.e("API Response", "Unsuccessful response: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Model_class>> call, Throwable t) {
                Log.e("API Response", "Failed to fetch data: " + t.getMessage());
            }
        });

    }
}