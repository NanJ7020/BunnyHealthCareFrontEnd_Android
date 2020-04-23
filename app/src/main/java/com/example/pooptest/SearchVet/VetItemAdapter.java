package com.example.pooptest.SearchVet;

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

import com.example.pooptest.Models.Yelp;
import com.example.pooptest.R;

import java.util.List;

public class VetItemAdapter extends ArrayAdapter<Yelp> {
    private List<Yelp> yelpList;
    private Context context;




    public VetItemAdapter(@NonNull Context context, int resource, @NonNull List<Yelp> objects) {
        super(context, resource, objects);
        this.yelpList = objects;
        this.context = context;
    }


    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view=layoutInflater.inflate(R.layout.list_view_vet_search_item,parent,false);

        //vet Image
        //*************gravatar should be Image url****************
        ImageView vetsVetImg=view.findViewById(R.id.vetImg_imageView);
        TextView vetsVetName=view.findViewById(R.id.vetName_textView);
        TextView vetsVetLocation=view.findViewById(R.id.vetAddress_textView);
        TextView vetsVetPhone=view.findViewById(R.id.vetPhone_textView);
        TextView vetsVetRating=view.findViewById(R.id.vetRating_textView);

        vetsVetName.setText(yelpList.get(position).getName());
        vetsVetLocation.setText(yelpList.get(position).getLocation());
        vetsVetPhone.setText(yelpList.get(position).getDisplay_phone());
        vetsVetRating.setText(yelpList.get(position).getRating());

        Button vetDetail_btn=view.findViewById(R.id.vetDetail_btn);

        vetDetail_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //link to records for Details
                Intent intent = new Intent(context, VetDetailActivity.class);
                intent.putExtra("index", position);
                context.startActivity(intent);
            }
        });



        return view;
    }
}
