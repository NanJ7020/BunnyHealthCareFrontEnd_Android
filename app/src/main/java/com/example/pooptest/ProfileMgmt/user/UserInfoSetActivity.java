package com.example.pooptest.ProfileMgmt.user;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.pooptest.Auth.LogInActivity;
import com.example.pooptest.HealthCare;
import com.example.pooptest.Models.BackEndRequest.ProfileUpdateRequest;
import com.example.pooptest.Models.Profile;
import com.example.pooptest.Models.User;
import com.example.pooptest.ProfileMgmt.ProfileMgmtBaseActivity;
import com.example.pooptest.ProfileMgmt.history.HistoryRecordListActivity;
import com.example.pooptest.ProfileMgmt.pet.PetListActivity;
import com.example.pooptest.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;




public class UserInfoSetActivity extends ProfileMgmtBaseActivity {

    TextView tv_userName,tv_email;
    EditText et_city,et_zipcode,et_state;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info_set);

        tv_userName=findViewById(R.id.userNameTextView);
        tv_email=findViewById(R.id.EmailTextView);

        tv_userName.setText(user.getUserName());
        tv_email.setText(user.getEmail());

        et_city=findViewById(R.id.city_editText);
        et_zipcode=findViewById(R.id.zipcode_editText);
        et_state=findViewById(R.id.state_editText);


        if (profile != null) {
            et_city.setText(profile.getCity());
            et_zipcode.setText(profile.getZipcode());
            et_state.setText(profile.getState());
        }
    }

    //onclick functions
    public void myBunny(View view) {
        if (profile == null) return;
        Intent intent = new Intent(this, PetListActivity.class);
        startActivity(intent);
    }

    public void myHistory(View view) {
        if (profile == null) return;
        Intent intent = new Intent(this, HistoryRecordListActivity.class);
        startActivity(intent);
    }

    public void mainMenu(View view) {
        if (profile == null) return;
        Intent intent = new Intent(this, HealthCare.class);
        startActivity(intent);
    }

    public void logOut(View view) {
        clearAuthData();
        CheckUserToken();
    }

    public void profileUpdate(View view){
        String city = et_city.getText().toString().trim();
        String zipcode = et_zipcode.getText().toString().trim();
        String state = et_state.getText().toString().trim();


        if (TextUtils.isEmpty(city)) {
            Toast.makeText(getApplicationContext(),"City is empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(zipcode) ||zipcode.length()<5) {
            Toast.makeText(getApplicationContext(),"Zip code shuld be 5 digits", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(state)) {
            Toast.makeText(getApplicationContext(),"State is empty", Toast.LENGTH_SHORT).show();
            return;
        }

        ProfileUpdateRequest profileUpdateRequest= new ProfileUpdateRequest(zipcode,state,city);
        Call<Profile> call= profileService.updateProfile(token, profileUpdateRequest);

        call.enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(),"Update failed",Toast.LENGTH_SHORT).show();
                    return;
                }

                profile = response.body();
                et_city.setText(profile.getCity());
                et_zipcode.setText(profile.getZipcode());
                et_state.setText(profile.getState());
                Log.i("TestInfo", "Get me is object from set");

                Toast.makeText(getApplicationContext(),"Succeed to Update File",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {

            }
        });


    }

    public void deleteAccount(View view){
        Call<Profile> call =profileService.deleteProfile(token);

        call.enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(),"Update failed",Toast.LENGTH_SHORT).show();
                    return;
                }


                Toast.makeText(getApplicationContext(),"Account Deletion",Toast.LENGTH_SHORT).show();

                //Delete user,profile,and posts by user id
                clearAuthData();

                //Check validation
                CheckUserToken();
            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {

            }
        });
    }

}
