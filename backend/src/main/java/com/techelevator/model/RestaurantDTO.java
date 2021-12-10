package com.techelevator.model;

public class RestaurantDTO {
    private String yelpId;
    private boolean isShown;

    public String getYelpId() {
        return yelpId;
    }

    public void setYelpId(String yelpId) {
        this.yelpId = yelpId;
    }

    public boolean getIsShown() {
        return isShown;
    }

    public void setShown(boolean shown) {
        isShown = shown;
    }
}
