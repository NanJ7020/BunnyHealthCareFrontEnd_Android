package com.example.pooptest.Posts;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.pooptest.HealthCare;
import com.example.pooptest.Models.BackEndResponse.GetAllPostResponse;
import com.example.pooptest.Models.Post;
import com.example.pooptest.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostMyPostListActivity extends PostBaseActivity  {

    ListView listView;
    String user_id="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_my_post_list);


        user_id=profile.getUser();
        Log.i("mypost",""+user_id);
        Call<GetAllPostResponse> call = postService.getMyPosts(user_id);

        call.enqueue(new Callback<GetAllPostResponse>() {
            @Override
            public void onResponse(Call<GetAllPostResponse> call, Response<GetAllPostResponse> response) {
                if (!response.isSuccessful()) {
                    Log.i("testMypost","failed: "+response.message());
                    return;
                }
                GetAllPostResponse getAllPostResponse = response.body();
                myPostList=getAllPostResponse.getPosts();
                myPostCount=getAllPostResponse.getCount();

                //Log.i("testMypost", ""+getAllPostResponse.getCount());
                //Log.i("testMypost", ""+getAllMyPostResponse.getMyPosts().size());


                ArrayList<Post> posts = getAllPostResponse.getPosts();





                listView=findViewById(R.id.myPosts_listView);

                PostItemAdapter adapter_mypostItem=new PostItemAdapter(getApplicationContext(),R.layout.list_view_post_my_item,myPostList);

                listView.setAdapter(adapter_mypostItem);

            }

            @Override
            public void onFailure(Call<GetAllPostResponse> call, Throwable t) {
                Log.i("testpost2",""+t.getMessage());
            }
        });


    }


    //onClick function
    public void mainMenu(View view) {
        Intent intent = new Intent(this, HealthCare.class );
        startActivity(intent);
    }
}
