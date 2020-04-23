package com.example.pooptest.ProfileMgmt;

import android.content.Intent;

import com.example.pooptest.AcctBaseActivity;
import com.example.pooptest.Auth.LogInActivity;
import com.example.pooptest.Services.ProfileService;

public class ProfileMgmtBaseActivity extends AcctBaseActivity {

    public static ProfileService profileService = retrofit.create(ProfileService.class);

    //token validation and verification
    public void CheckUserToken() {
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
