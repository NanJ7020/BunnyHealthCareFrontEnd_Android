package com.example.pooptest.Models;

public class User {
    private Object _id;
    private Object user;

    public User(Object _id, Object user) {
        this._id = _id;
        this.user = user;
    }

    public User() {
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
}
