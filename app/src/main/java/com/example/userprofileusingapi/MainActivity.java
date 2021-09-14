package com.example.userprofileusingapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
  RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewUsers);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<ApiResponse<Users>> call = apiInterface.getUsers();

        call.enqueue(new Callback<ApiResponse<Users>>() {
            @Override
            public void onResponse(Call<ApiResponse<Users>> call, Response<ApiResponse<Users>> response) {
                Log.d("call","onResponse"+response.body().toString());

                UsersAdapter usersAdapter = new UsersAdapter(response.body().usersDataList,getBaseContext());
                recyclerView.setAdapter(usersAdapter);

            }

            @Override
            public void onFailure(Call<ApiResponse<Users>> call, Throwable t) {
                Log.d("call","onResponse"+t.getMessage());

            }
        });


    }
}
