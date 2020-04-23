package com.example.pooptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.example.pooptest.PoopTest.CecalPoopActivity;
import com.example.pooptest.PoopTest.HealthPoopActivity;
import com.example.pooptest.PoopTest.StringPoopActivity;
import com.example.pooptest.PoopTest.WateryPoopActivity;
import com.example.pooptest.PoopTest.WormPoopActivity;
import com.example.pooptest.SearchVet.VetSearchActivity;
import com.example.pooptest.SearchVet.VetSearchBaseActivity;

public class PoopsView extends AcctBaseActivity {

    public void healthPoop(View view) {
        Intent intent=new Intent(this, HealthPoopActivity.class);
        startActivity(intent);
    }

    public void cecalPoop (View view) {
        Intent intent=new Intent(this, CecalPoopActivity.class);
        startActivity(intent);
    }

    public void stringPoop(View view) {
        Intent intent=new Intent(this, StringPoopActivity.class);
        startActivity(intent);
    }

    public void wormPoop(View view) {
        Intent intent=new Intent(this, WormPoopActivity.class);
        startActivity(intent);
    }

    public void wateryPoop(View view) {
        Intent intent=new Intent(this, WateryPoopActivity.class);
        startActivity(intent);
    }

    public void mainMenu(View view) {
        Intent intent=new Intent(this, HealthCare.class);
        startActivity(intent);
    }
/*



    public void wateryP_func (View view) {

        Toast toast = Toast.makeText(this,"Watery, no solid pieces, or entirely "
                        + "liquid. You need bring your bunny to see a vet as soon as possible.",
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL,
                0, 1220);
        toast.show();


        //looking for a vet
        Intent intent=new Intent(this, VetSearchActivity.class);
        startActivity(intent);

    }
*/








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poops_view);
    }
}
