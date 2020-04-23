package com.example.pooptest.ProfileMgmt.pet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.pooptest.ProfileMgmt.user.UserInfoSetActivity;
import com.example.pooptest.R;

public class PetListActivity extends PetBaseActivity {
    ListView listView;

    //Onclick functions
    public void myProfile (View view) {
        Intent intent = new Intent(this, UserInfoSetActivity.class);
        startActivity(intent);
    }

    public void addNewBun (View view) {
        Intent intent = new Intent(this, PetAddActivity.class );
        startActivity(intent);
    }


    //Adapter
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_list);

        petRecords=profile.getPets();

        listView=findViewById(R.id.pets_listView);
        PetItemAdapter adapter_petItem=new PetItemAdapter(this,R.layout.list_view_pet_item,petRecords);

        listView.setAdapter(adapter_petItem);
    }
}
