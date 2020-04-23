package com.example.pooptest.Models;

public class Yelp {
    private String id;
    private String name;
    private String image_url;
    private String rating;
    private String display_phone;
    private String distance;
    private String location;
    private String is_closed;

    public Yelp(String id, String name, String image_url, String rating, String display_phone, String distance, String location, String is_closed) {
        this.id = id;
        this.name = name;
        this.image_url = image_url;
        this.rating = rating;
        this.display_phone = display_phone;
        this.distance = distance;
        this.location = location;
        this.is_closed = is_closed;
    }

    public Yelp() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDisplay_phone() {
        return display_phone;
    }

    public void setDisplay_phone(String display_phone) {
        this.display_phone = display_phone;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIs_closed() {
        return is_closed;
    }

    public void setIs_closed(String is_closed) {
        this.is_closed = is_closed;
    }
}
