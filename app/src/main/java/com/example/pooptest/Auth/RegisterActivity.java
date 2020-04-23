package com.example.pooptest.Auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pooptest.Models.BackEndRequest.RegisterRequest;
import com.example.pooptest.Models.BackEndResponse.LoginResponse;
import com.example.pooptest.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AuthBaseActivity {

    EditText userNameEditText,emailEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        emailEditText=findViewById(R.id.email_EditText);
        userNameEditText=findViewById(R.id.userName_EditText);
    }


    //onClick functions
    public void logIn(View view) {
        Intent intent = new Intent(this, LogInActivity.class);
        startActivity(intent);
    }

    public void signUp(View view){
        String userName=userNameEditText.getText().toString().trim();
        String email=emailEditText.getText().toString().trim();

        if (TextUtils.isEmpty(userName)) {
            Toast.makeText(getApplicationContext(),"Enter a user name", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(),"Enter email address", Toast.LENGTH_SHORT).show();
            return;
        }

        RegisterRequest registerRequest=new RegisterRequest(email,email,userName);

        Call<LoginResponse> call=authService.register(registerRequest);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(),"Invalid Credentials",Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(getApplicationContext(),LogInActivity.class);
                startActivity(intent);

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
            }
        });
    }
}
