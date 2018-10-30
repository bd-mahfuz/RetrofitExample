package com.example.mahfuz.retrofitexample;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class PostActivity extends AppCompatActivity {

    private Button postBt;
    private TextInputLayout productName;
    private TextInputLayout productPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);


        postBt = findViewById(R.id.postBt);
        productName = findViewById(R.id.productNameEt);
        productPrice = findViewById(R.id.productPriceEt);

        postBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = productName.getEditText().getText().toString();
                double price = Double.valueOf(productPrice.getEditText().getText().toString());

                Product product = new Product();
                product.setName(name);
                product.setPrice(price);

                Log.d("product name:", product.getName());

                sendNetworkRequest(product);

            }
        });

    }

    private void sendNetworkRequest(Product product) {

        Retrofit retrofit = ProductClient.getRetrofitInstance();

        Api api = retrofit.create(Api.class);
        Call<Product> call = api.addProduct(product);
        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                Toast.makeText(PostActivity.this, "Product Name:"+ response.body().getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                Toast.makeText(PostActivity.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
