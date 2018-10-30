package com.example.mahfuz.retrofitexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Button getRequestBt;
    private Button postRequestBt;
    private Button putRequestBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getRequestBt = findViewById(R.id.getRequestBt);
        postRequestBt = findViewById(R.id.postRequestBt);
        putRequestBt = findViewById(R.id.putRequestBt);

        getRequestBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent getActivityIntent= new Intent(MainActivity.this, GetActivity.class);
                startActivity(getActivityIntent);
            }
        });

        postRequestBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent postActivityIntent= new Intent(MainActivity.this, PostActivity.class);
                startActivity(postActivityIntent);
            }
        });

        putRequestBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent postActivityIntent= new Intent(MainActivity.this, PostActivity.class);
                startActivity(postActivityIntent);
            }
        });

    }
}
