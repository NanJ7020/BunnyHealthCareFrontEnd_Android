package com.example.pooptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class PoopsView extends AppCompatActivity {
    /*
    public void healthP_func (View view) {
        Toast toast = Toast.makeText(this, "Congras!\nYour bunny's poop looks good!",
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL,
                0, 480);
        toast.show();
    }
*/
    /*
    public void cecalP_func (View view) {
        Toast toast = Toast.makeText(this,"These poops are completely normal, usually bunnies eat " +
                        "them to ensure that they get enough protein and B vitamins in their diet. " +
                        "\nSometimes bunnies will make more than normal when they're stressed or " +
                        "are getting too much sugar in their diet.",
                Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL,
                0, 820);
        toast.show();

    }
*/
    /*
    public void stringP_func (View view) {
        Toast toast = Toast.makeText(this,"These poops are linked together by shed hair.  " +
                        "Comb more regularly and suggest giving bunny more fiber.",
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL,
                0, 820);
        toast.show();

    }
*/
    /*
    public void wormP_func (View view) {
        Toast toast = Toast.makeText(this,"Some tape worm here. You need to contact vet "
                        + "and take laboratory test.",
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL,
                0, 820);
        toast.show();

    }
*/
    public void wateryP_func (View view) {
        /*
        Toast toast = Toast.makeText(this,"Watery, no solid pieces, or entirely "
                        + "liquid. You need bring your bunny to see a vet as soon as possible.",
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL,
                0, 1220);
        toast.show();
        */

        //looking for a vet
        /*setContentView(R.layout.popwindow);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.9),(int)(height*.9));*/

    }









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poops_view);
    }
}
