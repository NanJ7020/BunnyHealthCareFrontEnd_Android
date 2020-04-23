package com.example.pooptest.SearchVet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.pooptest.AcctBaseActivity;
import com.example.pooptest.Models.Yelp;
import com.example.pooptest.Posts.PostAddNewActivity;
import com.example.pooptest.R;

public class VetDetailActivity extends VetSearchBaseActivity {

    private int index=-1;
    TextView tv_vetImg,tv_vetName,tv_vetLocation,tv_vetRating,tv_vetPhone,tv_searchDistance,tv_isClosed;

    //onClick function
    public void SearchVet(View view){
        Intent intent=new Intent(this,VetSearchActivity.class);
        startActivity(intent);
    }

    public void selectVet(View view){
        //validation check
        if(index==-1){
            return;
        }
        //Intent to Add a new Post
        Intent intent=new Intent(this, PostAddNewActivity.class);
        //select a vet
        intent.putExtra("index",index);
        startActivity(intent);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vet_detail);

        tv_vetName = findViewById(R.id.sVetName_textView);
        tv_vetLocation=findViewById(R.id.sVetLocation_textView);
        tv_vetRating=findViewById(R.id.sVetRating_textView);
        tv_vetPhone=findViewById(R.id.sVetPhone_textView);
        tv_searchDistance=findViewById(R.id.sDistance_textView);
        tv_isClosed=findViewById(R.id.sVetIsOpen_textView);


        //new intent getting data textView
        Intent intent = getIntent();
        Integer i = intent.getIntExtra("index", 0);
        if (i != null) index = i;

        Yelp item = vetSearchResults.get(i);
        tv_vetName.setText(item.getName());
        tv_vetLocation.setText(item.getLocation());
        tv_vetRating.setText(item.getRating());
        tv_vetPhone.setText(item.getDisplay_phone());
        tv_searchDistance.setText(item.getDistance());
        tv_isClosed.setText(item.getIs_closed());
    }
}
