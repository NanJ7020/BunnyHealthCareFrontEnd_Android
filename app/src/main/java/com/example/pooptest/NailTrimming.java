package com.example.pooptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pooptest.SearchVet.VetSearchActivity;

public class NailTrimming extends AppCompatActivity {
    public void BackToMainMenu (View view) {
        Intent intent = new Intent(this,HealthCare.class );
        startActivity(intent);
    }

    public void findVet (View view) {
        Intent intent = new Intent(this, VetSearchActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nail_trimming);
    }
}
