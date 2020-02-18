package com.example.pooptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public void login(View view) {

        EditText BunnyNameEditText = findViewById(R.id.BunnyNameEditText);

        EditText BirthDateEditText = findViewById(R.id.OwnerBirthEditText);

        //invalid text
        String strBunnyName = BunnyNameEditText.getText().toString();
        String strBirthDate = BirthDateEditText.getText().toString();

        if(TextUtils.isEmpty(strBunnyName)) {
            //Log.i("hahahahah","Test");
            BunnyNameEditText.setError("cannot be empty");
            return;
        }

        if(TextUtils.isEmpty(strBirthDate)) {
           BirthDateEditText.setError("cannot be empty");
           return;
        }

    }

    public void register(View view) {
        Intent intent = new Intent(this,Registration.class );
        startActivity(intent);

    }

    private Button button;



                      @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.GuestButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                guest(view);
            }

            });
    }

    public void guest(View view) {
        Intent intent = new Intent(this,HealthCare.class);
        startActivity(intent);

    }
}