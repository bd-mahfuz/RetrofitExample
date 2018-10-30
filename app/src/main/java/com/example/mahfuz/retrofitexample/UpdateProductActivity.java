package com.example.mahfuz.retrofitexample;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UpdateProductActivity extends AppCompatActivity {

    private TextInputLayout mProductName;
    private TextInputLayout mProductPrice;

    private Button mUpdateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_product);

        mProductName = findViewById(R.id.uProductNameEt);
        mProductPrice = findViewById(R.id.uProductPriceEt);
        mUpdateButton = findViewById(R.id.updatePRoductBt);

        final Product product = (Product) getIntent().getSerializableExtra("product");

        Retrofit retrofit = ProductClient.getRetrofitInstance();

        Api api = retrofit.create(Api.class);
        Call<Product> call = api.getSingleProduct(product.getId());

        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                mProductName.getEditText().setText(response.body().getName());
                mProductPrice.getEditText().setText(response.body().getPrice()+"");
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                Toast.makeText(UpdateProductActivity.this, "Failed to fetch data!", Toast.LENGTH_SHORT).show();
            }
        });

        mUpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                product.setName(mProductName.getEditText().getText().toString());
                product.setPrice(Double.valueOf(mProductPrice.getEditText().getText().toString()));
                
                Retrofit retrofit1 = ProductClient.getRetrofitInstance();
                Api api1 = retrofit1.create(Api.class);
                Call<Product> call = api1.updateProduct(product, product.getId());
                
                call.enqueue(new Callback<Product>() {
                    @Override
                    public void onResponse(Call<Product> call, Response<Product> response) {
                        Toast.makeText(UpdateProductActivity.this, "Update succesful", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Product> call, Throwable t) {
                        Toast.makeText(UpdateProductActivity.this, "Update Failed", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
