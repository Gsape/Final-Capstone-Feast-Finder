package com.techelevator.model;

public class Restaurant {

    private Long restaurantId;
    private String yelpId;
    private boolean isShown;

    public Restaurant () {}

    public Restaurant(Long restaurantId, String yelpId, boolean isShown){
        this.restaurantId = restaurantId;
        this.yelpId = yelpId;
        this.isShown = isShown;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getYelpId() {
        return yelpId;
    }

    public void setYelpId(String yelpId) {
        this.yelpId = yelpId;
    }

    public boolean isShown() {
        return isShown;
    }

    public void setShown(boolean shown) {
        isShown = shown;
    }
}
