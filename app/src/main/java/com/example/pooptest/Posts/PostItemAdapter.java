package com.example.pooptest.Posts;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.pooptest.Models.Post;
import com.example.pooptest.R;

import java.util.List;

public class PostItemAdapter extends ArrayAdapter<Post> {
    private List<Post> postList;
    private Context context;


    public PostItemAdapter(@NonNull Context context, int resource, @NonNull List<Post> objects) {
        super(context,resource,objects);
        this.postList=objects;
        this.context=context;
    }


    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //Single item in List view
        View view=layoutInflater.inflate(R.layout.list_view_post_item,parent,false);

        TextView postsPostTitle=view.findViewById(R.id.postTitle_textView);
        TextView postsPostUserName=view.findViewById(R.id.postUserName_textView);
        TextView postsPostDate=view.findViewById(R.id.postDate_textView);

        Button postsDetailBtn=view.findViewById(R.id.postDetail_btn);

        postsPostTitle.setText(postList.get(position).getPostTitle());
        postsPostUserName.setText(postList.get(position).getUserName());
        postsPostDate.setText(postList.get(position).getDate().toString());

        postsDetailBtn .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //link to records for Details
                Intent intent = new Intent(context, PostDetailActivity.class);
                intent.putExtra("index", position);
                context.startActivity(intent);
            }
        });


        return view;
    }
}
