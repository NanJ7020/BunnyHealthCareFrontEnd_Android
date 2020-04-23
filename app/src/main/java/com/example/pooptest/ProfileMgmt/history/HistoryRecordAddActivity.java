package com.example.pooptest.ProfileMgmt.history;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pooptest.Models.BackEndRequest.HistoryAddRequest;
import com.example.pooptest.Models.Profile;
import com.example.pooptest.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoryRecordAddActivity extends HistoryRecordBaseActivity {
    EditText et_petName,et_weight, et_hospital,et_address,et_zipcode,et_visitTime,et_reason;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_record_add);

        et_petName=findViewById(R.id.bunnyNameEditText);
        et_weight=findViewById(R.id.h_weightEditText);
        et_hospital=findViewById(R.id.hospitalEditText);
        et_address=findViewById(R.id.addressEditText);
        et_zipcode=findViewById(R.id.zipcodeEditText);
        et_visitTime=findViewById(R.id.vistDateEditText);
        et_reason=findViewById(R.id.reasonEditText);
    }


    //onClick functions
    public void hospList(View view) {
        Intent intent = new Intent(this, HistoryRecordListActivity.class);
        startActivity(intent);
    }

    public void addHistoryRecord (View view){
        String pet = et_petName.getText().toString().trim();
        String weight=et_weight.getText().toString().trim();
        String hospital = et_hospital.getText().toString().trim();
        String address = et_address.getText().toString().trim();
        String zipcode = et_zipcode.getText().toString().trim();
        String reasonForHospital = et_reason.getText().toString().trim();
        String visitTime = et_visitTime.getText().toString().trim();

        if (TextUtils.isEmpty(pet)) {
            Toast.makeText(getApplicationContext(),"Pet Name is empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(weight)) {
            Toast.makeText(getApplicationContext(),"Weight is empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(hospital)) {
            Toast.makeText(getApplicationContext(),"Hospital is empty", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(address)) {
            Toast.makeText(getApplicationContext(),"Address is empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(zipcode)) {
            Toast.makeText(getApplicationContext(),"Zip code is empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(reasonForHospital)) {
            Toast.makeText(getApplicationContext(),"Reason for hospital is empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(visitTime)) {
            Toast.makeText(getApplicationContext(),"Visit time is empty", Toast.LENGTH_SHORT).show();
            return;
        }


        HistoryAddRequest historyAddRequest=new HistoryAddRequest(pet,weight,hospital,address,zipcode,
                reasonForHospital,visitTime);
        Call<Profile> call = profileService.addHistory(token,historyAddRequest);

        call.enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(),"Invalid Credentials",Toast.LENGTH_SHORT).show();
                    return;
                }


                profile = response.body();
                et_petName.setText(historyAddRequest.getPet());
                et_weight.setText(historyAddRequest.getWeight());
                et_address.setText(historyAddRequest.getAddress());
                et_zipcode.setText(historyAddRequest.getZipcode());
                et_hospital.setText(historyAddRequest.getZipcode());
                et_reason.setText(historyAddRequest.getReasonForHospital());
                et_visitTime.setText(historyAddRequest.getVisitTime());


                Intent intent= new Intent(getApplicationContext(), HistoryRecordListActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {

            }
        });

    }
}
