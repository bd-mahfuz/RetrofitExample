package com.example.mahfuz.retrofitexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by mahfuz on 8/6/18.
 */

public interface Api {

    @GET("products/{id}")
    Call<Product> getSingleProduct(@Path("id") int id);

    @GET("products")
    Call<List<Product>> getProductInfo();

    @POST("products")
    Call<Product> addProduct(@Body Product product);

    @PUT("products/{id}")
    Call<Product> updateProduct(@Body Product product, @Path("id") int id);

}
