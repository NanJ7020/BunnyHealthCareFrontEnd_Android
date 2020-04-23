package com.example.pooptest.PoopTest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pooptest.AcctBaseActivity;
import com.example.pooptest.PoopsView;
import com.example.pooptest.R;
import com.example.pooptest.SearchVet.VetSearchActivity;

public class WormPoopActivity extends AcctBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worm_poop);
    }

    //onClick function
    public void poopView(View view){
        Intent intent=new Intent(this, PoopsView.class);
        startActivity(intent);
    }

    public void searchAVet(View view){

        Intent intent=new Intent(this, VetSearchActivity.class);
        startActivity(intent);
    }
}
