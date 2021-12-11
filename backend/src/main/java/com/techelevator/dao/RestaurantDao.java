package com.techelevator.dao;

import com.techelevator.model.Restaurant;
import com.techelevator.model.RestaurantDTO;

import java.util.List;

public interface RestaurantDao {

    Long addNewRestaurant(RestaurantDTO restaurant);

    String addUserRestaurant(int userId, RestaurantDTO restaurant);

    boolean checkIfRestaurantExists(RestaurantDTO restaurant);

    List<String> getPreferences(int userId, boolean isShown);

}
