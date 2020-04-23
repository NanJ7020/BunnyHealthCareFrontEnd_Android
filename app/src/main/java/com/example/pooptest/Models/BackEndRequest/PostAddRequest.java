package com.example.pooptest.Models.BackEndRequest;

import java.util.Date;

public class PostAddRequest {
    private String yelpID;
    private String vetName;
    private String postTitle;
    private String image_url;
    private String address;
    private String phone;
    private boolean useful; //take care of bunny
    private boolean nailTrim;
    private boolean fleaCheck;
    private boolean spay_neutered;
    private boolean laboratory;
    private boolean GI_stasis;
    private Date date;


    public PostAddRequest(String yelpID, String vetName, String postTitle, String image_url,
                          String address, String phone, boolean useful, boolean nailTrim,
                          boolean fleaCheck, boolean spay_neutered, boolean laboratory, boolean GI_stasis, Date date) {
        this.yelpID = yelpID;
        this.vetName = vetName;
        this.postTitle = postTitle;
        this.image_url = image_url;
        this.address = address;
        this.phone = phone;
        this.useful = useful;
        this.nailTrim = nailTrim;
        this.fleaCheck = fleaCheck;
        this.spay_neutered = spay_neutered;
        this.laboratory = laboratory;
        this.GI_stasis = GI_stasis;
        this.date = date;


    }

    public PostAddRequest() {
    }

    public String getYelpID() {
        return yelpID;
    }

    public void setYelpID(String yelpID) {
        this.yelpID = yelpID;
    }

    public String getVetName() {
        return vetName;
    }

    public void setVetName(String vetName) {
        this.vetName = vetName;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }


    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isUseful() {
        return useful;
    }

    public void setUseful(boolean useful) {
        this.useful = useful;
    }

    public boolean isNailTrim() {
        return nailTrim;
    }

    public void setNailTrim(boolean nailTrim) {
        this.nailTrim = nailTrim;
    }

    public boolean isFleaCheck() {
        return fleaCheck;
    }

    public void setFleaCheck(boolean fleaCheck) {
        this.fleaCheck = fleaCheck;
    }

    public boolean isSpay_neutered() {
        return spay_neutered;
    }

    public void setSpay_neutered(boolean spay_neutered) {
        this.spay_neutered = spay_neutered;
    }

    public boolean isLaboratory() {
        return laboratory;
    }

    public void setLaboratory(boolean laboratory) {
        this.laboratory = laboratory;
    }

    public boolean isGI_stasis() {
        return GI_stasis;
    }

    public void setGI_stasis(boolean GI_stasis) {
        this.GI_stasis = GI_stasis;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
