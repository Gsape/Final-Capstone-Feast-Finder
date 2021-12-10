package com.techelevator.dao;

import com.techelevator.model.Restaurant;
import com.techelevator.model.RestaurantDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcRestaurantDao implements RestaurantDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcRestaurantDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Long addNewRestaurant(RestaurantDTO restaurant) {
        return null;
    }

    @Override
    public String addUserRestaurant(int userId, RestaurantDTO restaurant){
        String sql = "INSERT INTO user_restaurants (userId, yelp_id, is_shown) VALUES (?, ?, ?)";
        String result = jdbcTemplate.queryForObject(sql, String.class, userId, restaurant.getYelpId(), restaurant.getIsShown());
        return result;
    }

    @Override
    public boolean checkIfRestaurantExists(RestaurantDTO restaurant){
        String sql = "SELECT yelp_id FROM restaurants WHERE yelp_id = ?";
        String result = jdbcTemplate.queryForObject(sql, String.class, restaurant.getYelpId());
        if (restaurant.getYelpId().equals(result)){
            return true;
        }
        return false;
    }

    @Override
    public List<String> getPreferences(int userId, boolean isShown){
        List<String> preferences = new ArrayList<>();
        String sql = "SELECT yelp_id FROM user_restaurants WHERE user_id = ? AND is_shown is ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId, isShown);
        while (results.next()){
            String eachOne = results.getString("yelp_id");
            preferences.add(eachOne);
        }
        return preferences;
    }
}
