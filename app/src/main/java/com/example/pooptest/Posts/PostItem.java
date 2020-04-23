package com.example.pooptest.Posts;

public class PostItem {
    
    private String postVetName;
    private String postByName;
    private String postTime;
    private String postAddress;
    private String postCity;
    private String postZipcode;
    private String postState;
    private String postCareBun; //useful in the backend
    private String postSpayNeut;
    private String postNailTrim;
    private String postLab;
    private String postGIst;
    private String postFleaCheck;

    //constructor


    public PostItem(String postVetName, String postByName, String postTime, String postAddress,
                    String postCity, String postZipcode, String postState, String postCareBun,
                    String postSpayNeut, String postNailTrim, String postLab, String postGIst, String postFleaCheck) {
        this.postVetName = postVetName;
        this.postByName = postByName;
        this.postTime = postTime;
        this.postAddress = postAddress;
        this.postCity = postCity;
        this.postZipcode = postZipcode;
        this.postState = postState;
        this.postCareBun = postCareBun;
        this.postSpayNeut = postSpayNeut;
        this.postNailTrim = postNailTrim;
        this.postLab = postLab;
        this.postGIst = postGIst;
        this.postFleaCheck = postFleaCheck;
    }

    public PostItem() {
    }

    public String getPostVetName() {
        return postVetName;
    }

    public void setPostVetName(String postVetName) {
        this.postVetName = postVetName;
    }

    public String getPostByName() {
        return postByName;
    }

    public void setPostByName(String postByName) {
        this.postByName = postByName;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public String getPostAddress() {
        return postAddress;
    }

    public void setPostAddress(String postAddress) {
        this.postAddress = postAddress;
    }

    public String getPostCity() {
        return postCity;
    }

    public void setPostCity(String postCity) {
        this.postCity = postCity;
    }

    public String getPostZipcode() {
        return postZipcode;
    }

    public void setPostZipcode(String postZipcode) {
        this.postZipcode = postZipcode;
    }

    public String getPostState() {
        return postState;
    }

    public void setPostState(String postState) {
        this.postState = postState;
    }

    public String getPostCareBun() {
        return postCareBun;
    }

    public void setPostCareBun(String postCareBun) {
        this.postCareBun = postCareBun;
    }

    public String getPostSpayNeut() {
        return postSpayNeut;
    }

    public void setPostSpayNeut(String postSpayNeut) {
        this.postSpayNeut = postSpayNeut;
    }

    public String getPostNailTrim() {
        return postNailTrim;
    }

    public void setPostNailTrim(String postNailTrim) {
        this.postNailTrim = postNailTrim;
    }

    public String getPostLab() {
        return postLab;
    }

    public void setPostLab(String postLab) {
        this.postLab = postLab;
    }

    public String getPostGIst() {
        return postGIst;
    }

    public void setPostGIst(String postGIst) {
        this.postGIst = postGIst;
    }

    public String getPostFleaCheck() {
        return postFleaCheck;
    }

    public void setPostFleaCheck(String postFleaCheck) {
        this.postFleaCheck = postFleaCheck;
    }
}
