package com.example.pooptest.Posts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pooptest.Auth.LogInActivity;
import com.example.pooptest.Models.BackEndRequest.PostAddRequest;
import com.example.pooptest.Models.Post;
import com.example.pooptest.Models.Yelp;
import com.example.pooptest.R;
import com.example.pooptest.SearchVet.VetSearchActivity;
import com.example.pooptest.SearchVet.VetSearchBaseActivity;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostAddNewActivity extends PostBaseActivity {
    EditText et_postTitle;
    TextView tv_postVetName,tv_postVetLocation,tv_postPhone;

    String yelpID,vetName,postTile,image_url,phone,address,postBy;
    Date date;

    Integer index=-1;
    CheckBox checkCareBunny,checkSpay,checkNailTrim,checkLab,checkGIstasis,checkFlea;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_add_new);

        //new intent getting data textView
        Intent intent = getIntent();
        Integer i = intent.getIntExtra("index", 0);
        if (i != null) index = i;

        Yelp item = VetSearchBaseActivity.vetSearchResults.get(i);

        yelpID=item.getId();
        image_url=item.getImage_url();

        tv_postVetName=findViewById(R.id.npVetName_textView);
        tv_postVetLocation=findViewById(R.id.npAddress_textView);
        tv_postPhone=findViewById(R.id.npPhone_textView);
        et_postTitle=findViewById(R.id.npTitle_textView);

        tv_postVetName.setText(item.getName());
        tv_postVetLocation.setText(item.getLocation());
        tv_postPhone.setText(item.getDisplay_phone());

        checkCareBunny=findViewById(R.id.np_checkCareBunny);
        checkSpay=findViewById(R.id.np_checkSpay);
        checkNailTrim=findViewById(R.id.np_checkNailTrim);
        checkLab=findViewById(R.id.np_checkLab);
        checkGIstasis=findViewById(R.id.np_checkGIstasis);
        checkFlea=findViewById(R.id.np_checkFlea);
    }

    //onClick function
    public void vetSearchList(View view){
        Intent intent=new Intent(this, VetSearchActivity.class);
        startActivity(intent);
    }

    public void newPost(View view){
        String title=et_postTitle.getText().toString().trim();
        if (TextUtils.isEmpty(title)) {
            Toast.makeText(getApplicationContext(),"Post title is empty", Toast.LENGTH_SHORT).show();
            return;
        }


        postTile=et_postTitle.getText().toString();
        vetName=tv_postVetName.getText().toString();
        address=tv_postVetLocation.getText().toString();
        phone=tv_postPhone.getText().toString();

        boolean takeCareBunny = checkCareBunny.isChecked();
        boolean spay=checkSpay.isChecked();
        boolean nailTrim=checkNailTrim.isChecked();
        boolean lab=checkLab.isChecked();
        boolean GIstasis=checkGIstasis.isChecked();
        boolean flea=checkFlea.isChecked();

        date = Calendar.getInstance().getTime();



        PostAddRequest postAddRequest=new PostAddRequest(yelpID,vetName,postTile,image_url,address,
                phone,takeCareBunny,nailTrim,flea,spay,lab,GIstasis,date);

        Call<Post> call=postService.createPost(token,postAddRequest);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()) {
                    Log.i("posttest",""+response.code());
                    Toast.makeText(getApplicationContext(),"Fail to add new post",Toast.LENGTH_SHORT).show();
                    return;
                }



                Intent intent = new Intent(getApplicationContext(), PostListActivity.class);
                startActivity(intent);

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.i("posttest",""+t.getMessage());
            }
        });


    }
}
