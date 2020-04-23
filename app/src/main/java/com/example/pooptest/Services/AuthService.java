package com.example.pooptest.Services;

import com.example.pooptest.Models.BackEndRequest.HistoryAddRequest;
import com.example.pooptest.Models.BackEndRequest.LoginRequest;
import com.example.pooptest.Models.BackEndRequest.ProfileUpdateRequest;
import com.example.pooptest.Models.BackEndRequest.RegisterRequest;
import com.example.pooptest.Models.BackEndResponse.LoginResponse;
import com.example.pooptest.Models.Profile;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AuthService {

    @POST("/api/auth")
    Call<LoginResponse> login(@Body LoginRequest loginRequest);

    @POST("/api/users")
    Call<LoginResponse> register (@Body RegisterRequest registerRequest);



}
