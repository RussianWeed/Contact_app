package com.devking.contact_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements ClickLIstner {


    private static final int REFRESH_DELAY = 2000;
    public ArrayList<Model_class> dataset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView add_contact = findViewById(R.id.addContact);
        ImageView refresh =findViewById(R.id.refresh);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                recreate(); // Refresh the activity
            }
        }, REFRESH_DELAY);

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
            }
        });

        add_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              create_contact();
            }
        });



        RecyclerView recyclerView = findViewById(R.id.recylerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(dataset, this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


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
                if(response.isSuccessful() && response.body() != null){
                    dataset= (ArrayList<Model_class>) response.body();
                    adapter.updateData(dataset);
                }
                else {
                    Log.e("API Call", "Failed to get data: " + response.message());
                }

            }

            @Override
            public void onFailure(Call<List<Model_class>> call, Throwable t) {
                Log.e("API Call", "Failed: " + t.getMessage());
            }
        });

    }

    private void create_contact() {
        Intent intent = new Intent(this,Create_Contact.class);
        startActivity(intent);
    }

    public void onItemClick(int position) {
        if (position != RecyclerView.NO_POSITION){
            Intent intent = new Intent(this,MainActivity2.class);
            Model_class current_item = dataset.get(position);


            ArrayList<String> contact_details = new ArrayList<>();
            contact_details.add(current_item.getName());
            contact_details.add(current_item.getPhn_number().toString());
            contact_details.add(current_item.getAdhar_card().toString());


            intent.putStringArrayListExtra("contact_details",contact_details);
            startActivity(intent);

        }
    }


}