package com.example.pooptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HealthCare extends AppCompatActivity {
    public void PpTest(View view) {
        Intent intent = new Intent(this,PoopTest.class );
        startActivity(intent);
    }

    public void NailTrim(View view) {
        Intent intent = new Intent(this,NailTrimming.class );
        startActivity(intent);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_care);
    }
}
