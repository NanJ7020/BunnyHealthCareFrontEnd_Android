package com.example.pooptest.Models;

import java.util.ArrayList;
import java.util.Date;

public class Post {
    private Object _id;
    private Object user;
    private String userName;
    private String yelpID;
    private String vetName;
    private String postTitle;
    private String image_url;
    private String address;
    private String phone;
    private ArrayList<CheckUseful> useful;
    private ArrayList<CheckNailTrim> nailTrim;
    private ArrayList<CheckFleaChecking> fleaCheck;
    private ArrayList<CheckSpay> spay_neutered;
    private ArrayList<CheckLab> laboratory;
    private ArrayList<CheckGIstasis> GI_stasis;
    private Date date;

    public Post(Object _id, Object user, String userName, String yelpID, String vetName,
                String postTitle, String image_url, String address, String phone,
                ArrayList<CheckUseful> useful, ArrayList<CheckNailTrim> nailTrim,
                ArrayList<CheckFleaChecking> fleaCheck, ArrayList<CheckSpay> spay_neutered,
                ArrayList<CheckLab> laboratory, ArrayList<CheckGIstasis> GI_stasis, Date date) {
        this._id = _id;
        this.user = user;
        this.userName = userName;
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

    public Post() {
    }

    public Object get_id() {
        return _id;
    }

    public void set_id(Object _id) {
        this._id = _id;
    }

    public Object getUser() {
        return user;
    }

    public void setUser(Object user) {
        this.user = user;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public ArrayList<CheckUseful> getUseful() {
        return useful;
    }

    public void setUseful(ArrayList<CheckUseful> useful) {
        this.useful = useful;
    }

    public ArrayList<CheckNailTrim> getNailTrim() {
        return nailTrim;
    }

    public void setNailTrim(ArrayList<CheckNailTrim> nailTrim) {
        this.nailTrim = nailTrim;
    }

    public ArrayList<CheckFleaChecking> getFleaCheck() {
        return fleaCheck;
    }

    public void setFleaCheck(ArrayList<CheckFleaChecking> fleaCheck) {
        this.fleaCheck = fleaCheck;
    }

    public ArrayList<CheckSpay> getSpay_neutered() {
        return spay_neutered;
    }

    public void setSpay_neutered(ArrayList<CheckSpay> spay_neutered) {
        this.spay_neutered = spay_neutered;
    }

    public ArrayList<CheckLab> getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(ArrayList<CheckLab> laboratory) {
        this.laboratory = laboratory;
    }

    public ArrayList<CheckGIstasis> getGI_stasis() {
        return GI_stasis;
    }

    public void setGI_stasis(ArrayList<CheckGIstasis> GI_stasis) {
        this.GI_stasis = GI_stasis;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}