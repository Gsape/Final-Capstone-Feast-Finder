package com.techelevator.model;

import java.util.List;

public class Profile {
    private int zipCode;
    private int radius;
    private List<String> cuisineType;
    private String username; //Maybe userId

    public Profile() { }

    public Profile(int zipCode, int radius, List<String> cuisineType, String username){
        this.zipCode = zipCode;
        this.radius = radius;
        this.cuisineType = cuisineType;
        this.username = username;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public List<String> getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(List<String> cuisineType) {
        this.cuisineType = cuisineType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
