package com.example.pooptest.Auth;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pooptest.HealthCare;
import com.example.pooptest.Models.BackEndRequest.LoginRequest;
import com.example.pooptest.Models.BackEndRequest.RegisterRequest;
import com.example.pooptest.Models.BackEndResponse.LoginResponse;
import com.example.pooptest.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogInActivity extends AuthBaseActivity {

    EditText emailEditText;

    //onclick functions
    public void registered(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void login(View view) {
        String email = emailEditText.getText().toString().trim();
        Log.i("log","lalal");

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(),"Enter email address", Toast.LENGTH_SHORT).show();
            return;
        }

        LoginRequest loginRequest = new LoginRequest(email, email);

        Call<LoginResponse> call = authService.login(loginRequest);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (!response.isSuccessful()) {
                    Log.i("log","failLogin:"+response);
                    Toast.makeText(getApplicationContext(),"Invalid Credentials",Toast.LENGTH_SHORT).show();
                    return;

                }

                LoginResponse loginResponse = response.body();

                user = loginResponse.getUser();
                token = loginResponse.getToken();


                Intent intent= new Intent(getApplicationContext(), HealthCare.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.i("log","failed:"+t);
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        emailEditText = findViewById(R.id.emailEditText);
    }
}
