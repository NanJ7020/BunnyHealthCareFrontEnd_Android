package com.example.pooptest.PoopTest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.pooptest.AcctBaseActivity;
import com.example.pooptest.PoopsView;
import com.example.pooptest.R;

public class HealthPoopActivity extends AcctBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_poop);

    }


    //onClick function
    public void poopView(View view){
        Intent intent=new Intent(this, PoopsView.class);
        startActivity(intent);
    }
}
