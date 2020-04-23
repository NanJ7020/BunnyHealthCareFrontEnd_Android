package com.example.pooptest.Models;


import com.example.pooptest.ProfileMgmt.history.HistoryRecordItem;
import com.example.pooptest.ProfileMgmt.pet.PetItem;

import java.util.ArrayList;
import java.util.Date;

public class Profile {
    private String user;
    private String city;
    private String zipcode;
    private String state;
    private ArrayList<PetItem> pets;
    private ArrayList<HistoryRecordItem> history;
    private Date date;

    public Profile(String user, String city, String zipcode, String state, ArrayList<PetItem> petItems, ArrayList<HistoryRecordItem> historyRecordItems, Date date) {
        this.user = user;
        this.city = city;
        this.zipcode = zipcode;
        this.state = state;
        this.pets = petItems;
        this.history = historyRecordItems;
        this.date = date;
    }

    public Profile() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public ArrayList<PetItem> getPets() {
        return pets;
    }

    public void setPets(ArrayList<PetItem> pets) {
        this.pets = pets;
    }

    public ArrayList<HistoryRecordItem> getHistoryRecordItems() {
        return history;
    }

    public void setHistoryRecordItems(ArrayList<HistoryRecordItem> historyRecordItems) {
        this.history = historyRecordItems;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
