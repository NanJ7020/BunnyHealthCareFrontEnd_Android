package com.example.pooptest;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pooptest.Models.Profile;
import com.example.pooptest.Models.UserDto;
import com.example.pooptest.Posts.PostBaseActivity;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.pooptest.Posts.PostBaseActivity.cleanMyPost;
import static com.example.pooptest.Posts.PostBaseActivity.cleanPost;

public class AcctBaseActivity extends AppCompatActivity {
    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://healthcareserver-env.eba-uyjei9it.us-east-2.elasticbeanstalk.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    public static String token = null;
    public static UserDto user = null;  //Dto: Data Transfer Object
    public static Profile profile = null;

    public static void clearAuthData() {
        cleanPost();
        cleanMyPost();
        token = null;
        user = null;
        profile = null;
    }


}
