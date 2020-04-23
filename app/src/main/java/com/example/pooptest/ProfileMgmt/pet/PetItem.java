package com.example.pooptest.ProfileMgmt.pet;


public class PetItem {

    //pet Item
    private Object _id;
    private String petGravatar;
    private String petName;
    private String gender;
    private String age;
    private String weight;
    private String breed;
    private String spayed_neutered;

    public PetItem(String petGravatar, String petName, String gender, String age, String weight, String breed, String spayNeut) {
        this.petGravatar = petGravatar;
        this.petName = petName;
        this.gender = gender;
        this.age = age;
        this.weight = weight;
        this.breed = breed;
        this.spayed_neutered = spayNeut;
    }

    public PetItem() {
    }

    public String getPetGravatar() {
        return petGravatar;
    }

    public void setPetGravatar(String petGravatar) {
        this.petGravatar = petGravatar;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSpayNeut() {
        return spayed_neutered;
    }

    public void setSpayNeut(String spayNeut) {
        this.spayed_neutered = spayNeut;
    }

    public Object get_id() {
        return _id;
    }
}

