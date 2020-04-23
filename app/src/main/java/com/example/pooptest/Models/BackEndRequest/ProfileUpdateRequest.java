package com.example.pooptest.Models.BackEndRequest;

public class ProfileUpdateRequest {
    private String zipcode;
    private String state;
    private String city;

    public ProfileUpdateRequest(String zipcode, String state, String city) {
        this.zipcode = zipcode;
        this.state = state;
        this.city = city;
    }

    public ProfileUpdateRequest() {
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


}
