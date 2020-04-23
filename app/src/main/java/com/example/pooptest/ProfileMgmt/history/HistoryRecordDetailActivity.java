package com.example.pooptest.ProfileMgmt.history;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pooptest.Models.Profile;
import com.example.pooptest.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.pooptest.Auth.AuthBaseActivity.authService;

public class HistoryRecordDetailActivity extends HistoryRecordBaseActivity {

    private int index = -1;
    TextView tv_bunName, tv_hospName,tv_address,tv_zipcode,tv_visitTime,tv_reason;

    String history_id=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_record_detail);

        tv_bunName=findViewById(R.id.bunNameTextView);
        tv_hospName=findViewById(R.id.hospitalTextView);
        tv_address=findViewById(R.id.addressTextView);
        tv_zipcode=findViewById(R.id.zipCodeTextView);
        tv_visitTime=findViewById(R.id.visitTimeTextView);
        tv_reason=findViewById(R.id.reasonTextView);


        //new intent getting data textView
        Intent intent = getIntent();
        Integer i = intent.getIntExtra("index", 0);
        if (i != null) index = i;

        HistoryRecordItem item = hospitalRecords.get(i);
        tv_bunName.setText(item.getPet());
        tv_hospName.setText(item.getHospital());
        tv_address.setText(item.getAddress());
        tv_zipcode.setText(item.getZipcode());
        tv_visitTime.setText(item.getVisitTime());
        tv_reason.setText(item.getReasonForHospital());

        history_id=item.get_id().toString();
    }

    //onClick functions
    public void hospList(View view){
        Intent intent=new Intent(this, HistoryRecordListActivity.class);
        startActivity(intent);
    }

    public void deleteHistoryRecord(View view){

        Call<Profile> call=profileService.deleteHistory(history_id,token);

        call.enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(),"Detele Failure",Toast.LENGTH_SHORT).show();
                    return;
                }

                profile = response.body();

                Toast.makeText(getApplicationContext(),"History Record Deletion",Toast.LENGTH_SHORT).show();

                history_id=null;

                Intent intent= new Intent(getApplicationContext(), HistoryRecordListActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {

            }
        });
    }
}

