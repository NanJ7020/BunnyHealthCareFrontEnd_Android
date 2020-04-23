package com.example.pooptest.Services;

import com.example.pooptest.Models.BackEndRequest.YelpSearchRequest;
import com.example.pooptest.Models.BackEndResponse.YelpResponse;
import com.example.pooptest.Models.Yelp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface YelpSearchService {
    @POST("/api/yelp/search")
    Call<YelpResponse> getSearchVets(@Body YelpSearchRequest yelpSearchRequest);

}
