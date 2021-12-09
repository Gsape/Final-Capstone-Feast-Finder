package com.techelevator.dao;

import com.techelevator.model.Restaurant;
import com.techelevator.model.RestaurantDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcRestaurantDao implements RestaurantDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcRestaurantDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Long addNewRestaurant(RestaurantDTO restaurant){
        String sql = "INSERT INTO restaurants (restaurant_id, yelp_id, restaurant_name, is_shown) VALUES (default, '?', '?', true) RETURNING restaurant_id;";
        return jdbcTemplate.queryForObject(sql, Long.class, restaurant.getYelpId(), restaurant.getRestaurantName());
    }

//    @Override
//    public Restaurant addUserFave(int userId, Long restaurant_id){
//        Restaurant newR = new Restaurant();
//        String sql = "INSERT INTO user_restaurants (userId, retaurant_id) VALUES (?, ?)";
//        String result = jdbcTemplate.queryForObject(sql, String.class, userId, restaurant_id);
//        return newR;
//    }

    @Override
    public boolean checkIfRestaurantExists(RestaurantDTO restaurant){
        String sql = "SELECT yelp_id FROM restaurants WHERE yelp_id = ?";
        String result = jdbcTemplate.queryForObject(sql, String.class, restaurant.getYelpId());
        if (restaurant.getYelpId().equals(result)){
            return true;
        }
        return false;
    }
}
