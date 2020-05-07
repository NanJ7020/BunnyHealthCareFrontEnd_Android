package com.example.pooptest.Auth;

import android.content.Intent;

import com.example.pooptest.AcctBaseActivity;
import com.example.pooptest.HealthCare;
import com.example.pooptest.Services.AuthService;

public class AuthBaseActivity extends AcctBaseActivity {

    public static AuthService authService = retrofit.create(AuthService.class);
    
    @Override
    protected void onStart() {
        super.onStart();
        if (user != null) {
            startActivity(new Intent(this, HealthCare.class));
            finish();
        }
    }
}
