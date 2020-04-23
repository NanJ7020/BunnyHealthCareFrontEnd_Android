package com.example.pooptest.ProfileMgmt.pet;

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

import com.example.pooptest.R;

import java.util.List;


public class PetItemAdapter extends ArrayAdapter<PetItem> {
    private List<PetItem> myPetList;
    private Context context;



    public PetItemAdapter(@NonNull Context context, int resource, @NonNull List<PetItem> objects) {
        super(context, resource, objects);
        this.myPetList = objects;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //Single item in List view
        View view=layoutInflater.inflate(R.layout.list_view_pet_item,parent,false);

        TextView petsPetName=view.findViewById(R.id.petName_textView);

        //*************gravatar should be Image url****************
        ImageView petsPetImg=view.findViewById(R.id.pet_imageView);

        Button petsModifyBtn=view.findViewById(R.id.petModify_btn);

        petsPetName.setText(myPetList.get(position).getPetName());

        //*************gravatar should be Image url****************
        //petsPetImg.setText(myPetList.get(position).getPetGravatar());

        petsModifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //link to records for Details
                Intent intent = new Intent(context, PetUpdateActivity.class);
                intent.putExtra("index", position);
                context.startActivity(intent);
            }
        });

        return view;
    }
}

