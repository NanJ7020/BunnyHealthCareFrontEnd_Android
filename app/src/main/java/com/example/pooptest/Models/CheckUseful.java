package com.example.pooptest.Models;

public class CheckUseful {
    private Object _id;
    private Object user;



    public CheckUseful(Object _id, Object user) {
        this._id = _id;
        this.user = user;
    }


    public CheckUseful() {
    }

    public Object get_id() {
        return _id;
    }

    public Object getUser() {
        return user;
    }

    public void set_id(Object _id) {
        this._id = _id;
    }

    public void setUser(Object user) {
        this.user = user;
    }
}
