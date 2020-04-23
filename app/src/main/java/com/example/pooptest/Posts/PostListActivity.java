package com.example.pooptest.Posts;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.pooptest.HealthCare;
import com.example.pooptest.Models.BackEndResponse.GetAllPostResponse;
import com.example.pooptest.Models.CheckUseful;
import com.example.pooptest.Models.Post;
import com.example.pooptest.R;

import java.util.ArrayList;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PostListActivity extends PostBaseActivity {
    ListView listView;

    //onClick function
    public void mainMenu(View view) {
        Intent intent = new Intent(this, HealthCare.class );
        startActivity(intent);
    }

    public void myPosts(View view) {
        Intent intent = new Intent(this, PostMyPostListActivity.class );
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_list);


        Call<GetAllPostResponse> call = postService.getAllPosts();

        call.enqueue(new Callback<GetAllPostResponse>() {
            @Override
            public void onResponse(Call<GetAllPostResponse> call, Response<GetAllPostResponse> response) {
                if (!response.isSuccessful()) {
                    Log.i("testpost",""+response.message());
                    return;
                }
                GetAllPostResponse getAllPostResponse = response.body();
                postRecords=getAllPostResponse.getPosts();
                postCount=getAllPostResponse.getCount();

                Log.i("testpost", ""+getAllPostResponse.getCount());
                Log.i("testpost", ""+getAllPostResponse.getPosts().size());


                ArrayList<Post> posts = getAllPostResponse.getPosts();
                Log.i("testpost", ""+getAllPostResponse.getPosts().get(0).getUseful());
                Log.i("testpost", "get User: "+getAllPostResponse.getPosts().get(0).getUser());

                for (int i = 0; i < posts.size(); i++) {
                    Log.i("testpost", i+":"+posts.get(i).getUserName());
                    Log.i("testpost", i+"+Title:"+posts.get(i).getPostTitle());
                    Log.i("testpost", i+"+Useful check:"+posts.get(i).getUseful().size());
                    Log.i("testpost", i+"+nailTrim:"+posts.get(i).getNailTrim());
                    Log.i("testpost", i+"+Flea:"+posts.get(i).getFleaCheck());
                }

                String name=posts.get(0).getUserName();
                String yelpID=posts.get(0).getYelpID();
                String vetName=posts.get(0).getVetName();
                String postTitle=posts.get(0).getPostTitle();
                String image_url=posts.get(0).getImage_url();
                String address=posts.get(0).getAddress();
                String phone=posts.get(0).getPhone();
                ArrayList<CheckUseful> useful=posts.get(1).getUseful();
                Object nail=posts.get(0).getNailTrim();
                Object flea=posts.get(0).getFleaCheck();
                Object spay_neutered=posts.get(0).getSpay_neutered();
                Object GI=posts.get(0).getGI_stasis();
                Object lab=posts.get(0).getLaboratory();
                Date date=posts.get(0).getDate();

                //Log.i("testpost1","useful:"+useful.size());


                //postRecords.add(new Post());



                listView=findViewById(R.id.posts_listView);

                PostItemAdapter adapter_postItem=new PostItemAdapter(getApplicationContext(),R.layout.list_view_post_item,postRecords);

                listView.setAdapter(adapter_postItem);



            }

            @Override
            public void onFailure(Call<GetAllPostResponse> call, Throwable t) {
                Log.i("testpost2",""+t.getMessage());
            }
        });

    }
}
