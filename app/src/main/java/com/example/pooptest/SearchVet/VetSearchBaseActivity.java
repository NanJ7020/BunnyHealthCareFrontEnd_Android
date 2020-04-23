package com.example.pooptest.SearchVet;

import android.content.Intent;

import com.example.pooptest.AcctBaseActivity;
import com.example.pooptest.Auth.LogInActivity;
import com.example.pooptest.Models.BackEndResponse.YelpResponse;
import com.example.pooptest.Models.Yelp;
import com.example.pooptest.Services.YelpSearchService;

import java.util.ArrayList;
import java.util.List;

public class VetSearchBaseActivity extends AcctBaseActivity {
    public static List<Yelp> vetSearchResults= new ArrayList<>();
    public static YelpSearchService yelpSearchService=retrofit.create(YelpSearchService.class);

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
