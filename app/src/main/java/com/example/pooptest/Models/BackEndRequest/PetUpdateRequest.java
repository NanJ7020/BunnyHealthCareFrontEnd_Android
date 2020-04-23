package com.example.pooptest.Models.BackEndRequest;

public class PetUpdateRequest {
    private String petName;
    private String gender;
    private String age;
    private String weight;
    private String breed;
    private String spayed_neutered;

    public PetUpdateRequest( String petName, String gender, String age, String weight, String breed, String spayed_neutered) {

        this.petName = petName;
        this.gender = gender;
        this.age = age;
        this.weight = weight;
        this.breed = breed;
        this.spayed_neutered = spayed_neutered;
    }

    public PetUpdateRequest() {
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

    public String getSpayed_neutered() {
        return spayed_neutered;
    }

    public void setSpayed_neutered(String spayed_neutered) {
        this.spayed_neutered = spayed_neutered;
    }

}
