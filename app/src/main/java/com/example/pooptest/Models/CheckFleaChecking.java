package com.example.pooptest.Models;

public class CheckFleaChecking {
    Object _id;
    Object user;

    public CheckFleaChecking(Object _id, Object user) {
        this._id = _id;
        this.user = user;
    }

    public CheckFleaChecking() {
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
