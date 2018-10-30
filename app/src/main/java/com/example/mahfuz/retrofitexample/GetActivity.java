package com.example.mahfuz.retrofitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetActivity extends AppCompatActivity {

    private RecyclerView productListView;
    private List<Product> productList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get);

        productListView = findViewById(R.id.productRv);
        productListView.setLayoutManager(new LinearLayoutManager(GetActivity.this));

        Api api = ProductClient.getRetrofitInstance().create(Api.class);

        Call<List<Product>> call = api.getProductInfo();

        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                productList = response.body();
                Log.d("product list size:", productList.size()+"");
                ProductAdapter adapter = new ProductAdapter(GetActivity.this, productList);
                productListView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(GetActivity.this, "Failed!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
