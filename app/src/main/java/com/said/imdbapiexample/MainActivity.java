package com.said.imdbapiexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.said.imdbapiexample.Adapter.RecyclerViewAdapter;
import com.said.imdbapiexample.Api.ItemsInfo;
import com.said.imdbapiexample.Api.MovieApi;
import com.said.imdbapiexample.Api.MoviesInfo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ArrayList<ItemsInfo> movieModels;
    public static String BASE_URL= "https://imdb-api.com/";
    Retrofit retrofit;
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerView);

        Gson gson= new GsonBuilder().setLenient().create();

        retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        loadData();

    }

    public void loadData(){

        MovieApi movieApi =retrofit.create(MovieApi.class);

        Call<ItemsInfo> call=movieApi.getData();

        call.enqueue(new Callback<ItemsInfo>() {
            @Override
            public void onResponse(Call<ItemsInfo> call, Response<ItemsInfo> response) {
                ItemsInfo responseList=response.body();

                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerViewAdapter=new RecyclerViewAdapter(responseList);
                recyclerView.setAdapter(recyclerViewAdapter);
            }

            @Override
            public void onFailure(Call<ItemsInfo> call, Throwable t) {
                t.printStackTrace();

            }
        });




    }
}