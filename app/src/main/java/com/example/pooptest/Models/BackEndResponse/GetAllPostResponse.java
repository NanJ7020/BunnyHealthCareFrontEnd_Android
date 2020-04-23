package com.example.pooptest.Models.BackEndResponse;

import com.example.pooptest.Models.Post;

import java.util.ArrayList;

public class GetAllPostResponse {

    private ArrayList<Post> posts;
    private int count;

    public GetAllPostResponse(ArrayList<Post> posts, int count) {
        this.posts = posts;
        this.count = count;
    }

    public GetAllPostResponse() {
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
