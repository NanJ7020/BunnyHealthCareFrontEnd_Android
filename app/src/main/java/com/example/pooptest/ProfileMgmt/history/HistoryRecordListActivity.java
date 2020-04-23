package com.example.pooptest.ProfileMgmt.history;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.pooptest.ProfileMgmt.user.UserInfoSetActivity;
import com.example.pooptest.R;

public class HistoryRecordListActivity extends HistoryRecordBaseActivity {
    ListView listView;

    //onClick functions
    public void myProfile(View view) {
        Intent intent = new Intent(this, UserInfoSetActivity.class);
        startActivity(intent);
    }

    public void addRecord(View view) {
        Intent intent = new Intent(this, HistoryRecordAddActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_list);

        hospitalRecords = profile.getHistoryRecordItems();


        listView=findViewById(R.id.records_listView);
        HistoryRecordListAdapter adapter_hospitalItem=new HistoryRecordListAdapter(this,R.layout.list_view_history_item,hospitalRecords);

        listView.setAdapter(adapter_hospitalItem);
    }
}

