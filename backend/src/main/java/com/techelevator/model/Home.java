package com.techelevator.model;

public class Home {

    private int radius;
    private int zipCode;

    public Home() { }

    public Home(int radius, int zipCode){
        this.radius = radius;
        this.zipCode = zipCode;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
    @Override
    public String toString() {
        return "Home search is a radius of " + radius + " miles around the zipcode of " + zipCode;

    }
}
