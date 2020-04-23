package com.example.pooptest.Models.BackEndRequest;

import java.util.Date;

public class HistoryAddRequest {
    private String pet;
    private String weight;
    private String hospital;
    private String address;
    private String zipcode;
    private String reasonForHospital;
    private String visitTime;

    public HistoryAddRequest(String pet, String weight, String hospital, String address, String zipcode, String reasonForHospital, String visitTime) {
        this.pet = pet;
        this.weight = weight;
        this.hospital = hospital;
        this.address = address;
        this.zipcode = zipcode;
        this.reasonForHospital = reasonForHospital;
        this.visitTime = visitTime;
    }

    public HistoryAddRequest() {
    }

    public String getPet() {
        return pet;
    }

    public void setPet(String pet) {
        this.pet = pet;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getReasonForHospital() {
        return reasonForHospital;
    }

    public void setReasonForHospital(String reasonForHospital) {
        this.reasonForHospital = reasonForHospital;
    }

    public String getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }
}
