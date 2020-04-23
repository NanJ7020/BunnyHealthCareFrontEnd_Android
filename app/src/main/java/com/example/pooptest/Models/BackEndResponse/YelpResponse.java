package com.example.pooptest.Models.BackEndResponse;

import com.example.pooptest.Models.Yelp;

import java.util.ArrayList;

public class YelpResponse {
    private ArrayList<Yelp> yelps;

    public YelpResponse(ArrayList<Yelp> yelp) {
        this.yelps = yelp;
    }

    public ArrayList<Yelp> getYelp() {
        return yelps;
    }

    public void setYelp(ArrayList<Yelp> yelp) {
        this.yelps = yelp;
    }
}
