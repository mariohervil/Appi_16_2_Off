package com.example.appi_16_2_off;

import static com.example.appi_16_2_off.Model.ApiUtil.API_KEY;

import com.example.appi_16_2_off.Model.Images;
import com.example.appi_16_2_off.Model.Search;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiIntf {

    @Headers("Authorization: Client-ID "+ API_KEY)
    @GET("/photos")
    Call<List<Images>> getImages(
            @Query("page") int page,
            @Query("per_page") int perPage
    );
    @Headers("Authorization: Client-ID "+ API_KEY)
    @GET("search/photos")
    Call<Search> searchImage(
            @Query("query") String query,
            @Query("per_page") int perPage
    );
}
