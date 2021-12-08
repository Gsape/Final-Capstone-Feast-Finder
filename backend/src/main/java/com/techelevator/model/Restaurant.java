package com.techelevator.model;

public class Restaurant {

    private int restaurantId;
    private String yelpId;
    private String restaurantName;
    private boolean isShown;

    public Restaurant () {}

    public Restaurant(int restaurantId, String yelpId, String restaurantName, boolean isShown){
        this.restaurantId = restaurantId;
        this.yelpId = yelpId;
        this.restaurantName =restaurantName;
        this.isShown = isShown;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getYelpId() {
        return yelpId;
    }

    public void setYelpId(String yelpId) {
        this.yelpId = yelpId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public boolean isShown() {
        return isShown;
    }

    public void setShown(boolean shown) {
        isShown = shown;
    }
}
