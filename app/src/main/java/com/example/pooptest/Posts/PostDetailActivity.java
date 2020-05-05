package com.example.pooptest.Posts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pooptest.Models.Post;
import com.example.pooptest.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostDetailActivity extends PostBaseActivity {

    private int index=-1;
    TextView tv_vetName,tv_pAddress,tv_pTitle,tv_pPhone,tv_pCareBun,tv_pSpayNeut,
            tv_pNailTrim,tv_pLab,tv_pGIst,tv_pFleaChk,tv_pPsotBy,tv_pPostOn;

    String post_id="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);

        tv_vetName=findViewById(R.id.pVetName_textView);
        tv_pAddress=findViewById(R.id.pAddress_textView);
        tv_pPhone=findViewById(R.id.pPhone_textView);
        tv_pTitle=findViewById(R.id.pTitle_textView);
        tv_pPostOn=findViewById(R.id.pPostOn_textView);
        tv_pPsotBy=findViewById(R.id.pPostBy_textView);
        tv_pCareBun=findViewById(R.id.postCareBun_textView); //useful in Post
        tv_pSpayNeut=findViewById(R.id.postSpayNeut_textView);
        tv_pNailTrim=findViewById(R.id.postNailTrim_textView);
        tv_pLab=findViewById(R.id.postLab_textView);
        tv_pGIst=findViewById(R.id.postGIs_textView);
        tv_pFleaChk=findViewById(R.id.postFleaChk_textView);

        //new intent getting data textView
        Intent intent = getIntent();
        Integer i = intent.getIntExtra("index", 0);
        if (i != null) index = i;

        Post item = postRecords.get(i);
        tv_vetName.setText(item.getVetName());
        tv_pPsotBy.setText(item.getUserName());
        tv_pPostOn.setText(item.getDate().toString());
        tv_pAddress.setText(item.getAddress());
        tv_pTitle.setText(item.getPostTitle());
        tv_pPhone.setText(item.getPhone());

        tv_pCareBun.setText(""+item.getUseful().size());
        tv_pSpayNeut.setText(""+item.getSpay_neutered().size());
        tv_pNailTrim.setText(""+item.getNailTrim().size());
        tv_pLab.setText(""+item.getLaboratory().size());
        tv_pGIst.setText(""+item.getGI_stasis().size());
        tv_pFleaChk.setText(""+item.getFleaCheck().size());

        //Log.i("testpoost","detail post info: "+item.getUser());
        post_id=item.get_id().toString();



    }

    //onClick function
    public void postList(View view){
        Intent intent=new Intent(this,PostListActivity.class);
        startActivity(intent);
    }

    public void deletePost(View view) {
        Log.i("testpoost","post id: "+post_id);
        Log.i("testpoost","token: "+token);

        Call<Post> call=postService.deletePostByPostID(post_id,token);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if (!response.isSuccessful()) {
                    if (response.code() == 400) {
                        Log.i("testpostDe",""+response.message());
                        Toast.makeText(getApplicationContext(),"Post not Found",Toast.LENGTH_SHORT).show();
                    }
                    return;
                }

                post_id=null;

                Toast.makeText(getApplicationContext(),"Post Delete",Toast.LENGTH_SHORT).show();


                Intent intent= new Intent(getApplicationContext(), PostListActivity.class);
                startActivity(intent);

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Post Delete",Toast.LENGTH_SHORT).show();
                Log.i("testpoost","failed reso: "+t.getMessage());
            }
        });
    }

    public void takeCareBunnyCheck(View view){
        Call<Post> call=postService.takeCareBunny(post_id,token);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()) {
                    if (response.code() == 400) {
                        Log.i("takcareBun","400fail: "+response.message());
                        Toast.makeText(getApplicationContext(),"Post not Found",Toast.LENGTH_SHORT).show();
                    }
                    Log.i("takcareBun","no 400: "+response.message());
                    return;
                }
                Intent intent=new Intent(getApplicationContext(),PostListActivity.class);
                startActivity(intent);

                Log.i("takcareBun","success");
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.i("takecareBun","failed: "+t.getMessage());
            }
        });
    }
}
