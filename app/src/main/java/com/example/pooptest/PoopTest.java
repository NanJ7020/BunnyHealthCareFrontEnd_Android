package com.example.pooptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class PoopTest extends AppCompatActivity {

    public void healthP_func (View view) {
        Toast toast = Toast.makeText(this, "Congras!\nYour bunny's poop looks good!",
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL,
                0, 480);
        toast.show();
    }

    public void cecalP_func (View view) {
        Toast toast = Toast.makeText(this,"These poops are completely normal, usually bunnies eat " +
                        "them to ensure that they get enough protein and B vitamins in their diet. " +
                        "\nSometimes bunnies will make more than normal when they're stressed or " +
                        "are getting too much sugar in their diet.",
                Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL,
                0, 680);
        toast.show();

    }

    public void searchByGoogle (View view) {
        Intent browserIntent = new Intent(this,SearchByGoogle.class );
        //Intent browserIntent = new Intent (Intent.ACTION_VIEW, Uri.parse("https://images.google.com/?gws_rd=ssl"));
                startActivity(browserIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poop_test);
    }
}
