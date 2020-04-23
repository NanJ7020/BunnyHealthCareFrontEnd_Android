package com.example.pooptest.Posts;

import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pooptest.AcctBaseActivity;
import com.example.pooptest.Auth.LogInActivity;
import com.example.pooptest.Models.Post;
import com.example.pooptest.Services.PostService;

import java.util.ArrayList;
import java.util.List;

public class PostBaseActivity extends AcctBaseActivity {
    public static List<Post> postRecords= new ArrayList<>();
    public static List<Post> myPostList= new ArrayList<>();
    public static PostService postService=retrofit.create(PostService.class);
    public static int postCount=0;
    public static int myPostCount=0;


    //clean all post
    public static void cleanPost(){
        postRecords= new ArrayList<>();
        postCount=0;
    }

    public static void cleanMyPost(){
        myPostList= new ArrayList<>();
        myPostCount=0;
    }


    //token validation and verification
    public void CheckUserToken() {
        if (user == null) {
            startActivity(new Intent(this, LogInActivity.class));
            finish();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        CheckUserToken();
    }
}
