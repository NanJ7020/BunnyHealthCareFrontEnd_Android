package com.example.pooptest.Services;

import com.example.pooptest.Models.BackEndRequest.HistoryAddRequest;
import com.example.pooptest.Models.BackEndRequest.PetAddRequest;
import com.example.pooptest.Models.BackEndRequest.PetUpdateRequest;
import com.example.pooptest.Models.BackEndRequest.ProfileUpdateRequest;
import com.example.pooptest.Models.Profile;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ProfileService {
    @GET("/api/profile/me")
    Call<Profile> getProfile (@Header("x-auth-token") String authToken);

    @POST("/api/profile")
    Call<Profile> updateProfile (@Header("x-auth-token") String authToken,
                                 @Body ProfileUpdateRequest profileUpdateRequest);

    @DELETE("/api/profile")
    Call<Profile> deleteProfile(@Header("x-auth-token") String authToken);

    @PUT("/api/profile/history")
    Call<Profile> addHistory(@Header("x-auth-token") String authToken,
                             @Body HistoryAddRequest historyAddRequest);

    @DELETE("/api/profile/history/{history_id}")
    Call<Profile> deleteHistory(@Path("history_id") String history_id,
                                @Header("x-auth-token") String authToken);

    @PUT("/api/profile/pets")
    Call<Profile> addPet(@Header("x-auth-token") String authToken,
                         @Body PetAddRequest petAddRequest);

    @PUT("/api/profile/pets/{pet_id}")
    Call<Profile> updatePet(@Path("pet_id")String pet_id,
                            @Header("x-auth-token") String authToken,
                            @Body PetUpdateRequest petUpdateRequest);

    @DELETE("/api/profile/pets/{pet_id}")
    Call<Profile> deletePet(@Path("pet_id")String pet_id,
                            @Header("x-auth-token") String authToken);

}
