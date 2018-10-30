package com.example.mahfuz.retrofitexample;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mahfuz on 8/8/18.
 */

public class ProductClient {

    private static Retrofit retrofit;
    public static final String BASE_URL = "http://192.168.0.102:3000/";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {

            OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();

            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            // enable only in debug mode not production mode
            if (BuildConfig.DEBUG) {
                okHttpClient.addInterceptor(loggingInterceptor);
            }

            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient.build()).build();
        }

        return retrofit;
    }

}
