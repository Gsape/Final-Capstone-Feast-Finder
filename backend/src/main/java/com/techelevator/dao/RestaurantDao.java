package com.techelevator.dao;

import com.techelevator.model.Restaurant;
import com.techelevator.model.RestaurantDTO;

public interface RestaurantDao {

    Long addNewRestaurant(RestaurantDTO restaurant);

//    Restaurant addUserFave(int userId, RestaurantDTO restaurant);

    boolean checkIfRestaurantExists(RestaurantDTO restaurant);


}
