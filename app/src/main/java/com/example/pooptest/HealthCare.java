package com.example.pooptest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.pooptest.Auth.LogInActivity;
import com.example.pooptest.Models.Profile;
import com.example.pooptest.Posts.PostListActivity;
import com.example.pooptest.ProfileMgmt.ProfileMgmtBaseActivity;
import com.example.pooptest.SearchVet.VetSearchActivity;
import com.example.pooptest.ProfileMgmt.user.UserInfoSetActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HealthCare extends AcctBaseActivity {
    public void myProfile(View view) {
        Intent intent = new Intent(this, UserInfoSetActivity.class );
        startActivity(intent);
    }

    public void PpTest(View view) {
        Intent intent = new Intent(this,PoopsView.class );
        startActivity(intent);
    }

    public void NailTrim(View view) {
        Intent intent = new Intent(this,NailTrimming.class );
        startActivity(intent);
    }

    public void searchVet (View view) {
        Intent intent = new Intent (this, VetSearchActivity.class);
        startActivity(intent);
    }

    public void community (View view) {
        Intent intent = new Intent(this, PostListActivity.class);
        startActivity(intent);
    }

    public void logOut(View view) {
        clearAuthData();
        CheckUserToken();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_care);

        Call<Profile> call = ProfileMgmtBaseActivity.profileService.getProfile(token);

        call.enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {
                if (!response.isSuccessful()) {
                    if (response.code() == 400) {
                        Toast.makeText(getApplicationContext(),"No profile",Toast.LENGTH_SHORT).show();

                        //Intent intent =new Intent(getApplicationContext(),UserInfoSetActivity.class);
                        //startActivity(intent);
                    }
                    return;
                }

                profile = response.body();
                Log.i("TestInfo", "Get me is object");
            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {
                //Intent intent =new Intent(getApplicationContext(),UserInfoSetActivity.class);
                //startActivity(intent);
                Log.i("TestInfo", "Failed: " + t.getMessage());
            }
        });
    }

    //token validation and verification
    public void CheckUserToken() {
        Log.i("TestCall", "HealthCare: " + (user == null) + " | " + token);
        if (user == null) {
            startActivity(new Intent(this, LogInActivity.class));
            finish();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        CheckUserToken();
    }

}
