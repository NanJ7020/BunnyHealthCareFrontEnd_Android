package com.example.pooptest.ProfileMgmt.pet;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pooptest.Models.BackEndRequest.PetUpdateRequest;
import com.example.pooptest.Models.Profile;
import com.example.pooptest.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.pooptest.ProfileMgmt.ProfileMgmtBaseActivity.profileService;

public class PetUpdateActivity extends PetBaseActivity {

    private int index = -1;
    EditText et_petName,et_petGender,et_petAge,et_petWeight,et_petBreed,et_petSpayNeut;
    String pet_id=null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_update);

        et_petName=findViewById(R.id.bunNameEditText);
        et_petGender=findViewById(R.id.genderEditText);
        et_petAge=findViewById(R.id.ageEditText);
        et_petWeight=findViewById(R.id.weightEditText);
        et_petBreed=findViewById(R.id.breedEditText);
        et_petSpayNeut=findViewById(R.id.spay_neuteredEditText);


        //new intent getting data textView
        Intent intent = getIntent();
        Integer i = intent.getIntExtra("index", 0);
        if (i != null) index = i;

        PetItem item = petRecords.get(i);

        pet_id=item.get_id().toString();

        Call<Profile> call=profileService.getProfile(token);

        call.enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {
                if (!response.isSuccessful()) {
                    if (response.code() == 400) {
                        Toast.makeText(getApplicationContext(),"No pet",Toast.LENGTH_SHORT).show();
                    }
                    return;
                }

                profile = response.body();
                et_petName.setText(item.getPetName());
                et_petGender.setText(item.getGender());
                et_petAge.setText(item.getAge());
                et_petWeight.setText(item.getWeight());
                et_petBreed.setText(item.getBreed());
                et_petSpayNeut.setText(item.getSpayNeut());

            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {

            }
        });

    }

    //onclick functions
    public void bunnyList(View view) {
        Intent intent = new Intent(this, PetListActivity.class );
        startActivity(intent);
    }

    public void updatePet(View view){

        String name=et_petName.getText().toString().trim();
        String gender=et_petGender.getText().toString().trim();
        String age=et_petAge.getText().toString().trim();
        String breed=et_petBreed.getText().toString().trim();
        String weight=et_petWeight.getText().toString().trim();
        String spay=et_petSpayNeut.getText().toString().trim();

        //new intent getting data textView
        Intent intent = getIntent();
        Integer i = intent.getIntExtra("index", 0);
        if (i != null) index = i;

        PetItem item = petRecords.get(i);

        pet_id=item.get_id().toString();

        if (TextUtils.isEmpty(name)) {
            Toast.makeText(getApplicationContext(),"Pet Name is empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(weight)) {
            Toast.makeText(getApplicationContext(),"Weight is empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(age)) {
            Toast.makeText(getApplicationContext(),"Age is empty", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(gender)) {
            Toast.makeText(getApplicationContext(),"Gender is empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(breed)) {
            Toast.makeText(getApplicationContext(),"Breed is empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(spay)) {
            Toast.makeText(getApplicationContext(),"Spay neutered is empty", Toast.LENGTH_SHORT).show();
            return;
        }

        Log.i("pet","111: ");
        PetUpdateRequest petUpdateRequest =new PetUpdateRequest(name,gender,age,weight,breed,spay);

        Call<Profile> call=profileService.updatePet(pet_id,token, petUpdateRequest);
        call.enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {
                Log.i("pet",""+response.message());
                if (!response.isSuccessful()) {
                    if (response.code() == 400) {
                        Toast.makeText(getApplicationContext(),"Update Pet Failed",Toast.LENGTH_SHORT).show();
                    }
                    return;
                }


                profile=response.body();

                Log.i("pet","111: "+response.message());
                Intent intent= new Intent(getApplicationContext(), PetListActivity.class);
                startActivity(intent);


            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {
                Log.i("pet","111: "+t.getMessage());
            }
        });
    }

    public void deletePet(View view){
        Call<Profile> call= profileService.deletePet(pet_id,token);
        call.enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {
                if (!response.isSuccessful()) {
                    if (response.code() == 400) {
                        Toast.makeText(getApplicationContext(),"Delete Pet Failed",Toast.LENGTH_SHORT).show();
                    }
                    return;
                }

                profile=response.body();


                Intent intent= new Intent(getApplicationContext(), PetListActivity.class);
                startActivity(intent);

            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {

            }
        });
    }
}
