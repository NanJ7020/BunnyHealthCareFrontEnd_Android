package com.example.pooptest.Models.BackEndRequest;

public class YelpSearchRequest {
    private String term;
    private String location;
    private String categories;
    private String limit;

    public YelpSearchRequest(String term, String location, String categories, String limit) {
        this.term = term;
        this.location = location;
        this.categories = categories;
        this.limit = limit;
    }

    public YelpSearchRequest() {
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }
}
