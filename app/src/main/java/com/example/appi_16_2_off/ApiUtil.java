package com.example.appi_16_2_off;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtil {
    public static final String BASE_URL = "https://api.unsplash.com";
    public static final String API_KEY = "V9aaJ9tmuIBxgY4q40S9S2HNHTVhFjay0lcUzIwr5fM";

    public static Retrofit retrofit = null;

    public static ApiIntf getApiInterface(){
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit.create(ApiIntf.class);
    }

}
