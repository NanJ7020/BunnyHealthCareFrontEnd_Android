package com.example.pooptest.ProfileMgmt.pet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pooptest.Models.BackEndRequest.PetAddRequest;
import com.example.pooptest.Models.Profile;
import com.example.pooptest.R;
import com.example.pooptest.Services.ProfileService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PetAddActivity extends PetBaseActivity {

    EditText et_name,et_gender,et_age,et_weight,et_breed,et_spay_neut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_add);

        et_name=findViewById(R.id.bunNameText);
        et_gender=findViewById(R.id.genderText);
        et_age=findViewById(R.id.ageText);
        et_weight=findViewById(R.id.weightText);
        et_breed=findViewById(R.id.breedText);
        et_spay_neut=findViewById(R.id.spay_neuteredText);
    }


    //onClick functions
    public void bunnyList(View view) {
        Intent intent=new Intent(this, PetListActivity.class);
        startActivity(intent);
    }

    public void addBunny(View view) {
        String name=et_name.getText().toString().trim();
        String gender=et_gender.getText().toString().trim();
        String age=et_age.getText().toString().trim();
        String weight=et_weight.getText().toString().trim();
        String breed=et_breed.getText().toString().trim();
        String spay=et_spay_neut.getText().toString().trim();

        if (TextUtils.isEmpty(name)) {
            Toast.makeText(getApplicationContext(),"Pet Name is empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(gender)) {
            Toast.makeText(getApplicationContext(),"Gender is empty", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(age)) {
            Toast.makeText(getApplicationContext(),"Age is empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(weight)) {
            Toast.makeText(getApplicationContext(),"Weight is empty", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(breed)) {
            Toast.makeText(getApplicationContext(),"Breed is empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(spay)) {
            Toast.makeText(getApplicationContext(), "Spay/Neutered is empty", Toast.LENGTH_SHORT).show();
            return;
        }

        PetAddRequest petAddRequest=new PetAddRequest(name,gender,age,weight,breed,spay);

        Call<Profile>call=profileService.addPet(token,petAddRequest);

        call.enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {
                if (!response.isSuccessful()) {
                      Toast.makeText(getApplicationContext(),"Fail to add pet",Toast.LENGTH_SHORT).show();
                      return;
                  }

                 profile = response.body();

                 Intent intent= new Intent(getApplicationContext(), PetListActivity.class);
                 startActivity(intent);
            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {

            }
        });



    }
}
