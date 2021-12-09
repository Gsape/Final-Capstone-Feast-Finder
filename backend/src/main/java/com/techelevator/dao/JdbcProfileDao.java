package com.techelevator.dao;

import com.techelevator.model.Profile;
import com.techelevator.model.ProfileDTO;
import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcProfileDao implements ProfileDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcProfileDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Long> getCuisineIds(String[] cuisines){ // ["thai", "pizza"]
        String sql = "SELECT cuisine_id FROM cuisine WHERE cuisine_type IN (?)";
        String stringCuisines = "";
        int lengthArray = cuisines.length; // 2
        for (int i = 0; i < lengthArray; i++){
            if (i < lengthArray-1){
                stringCuisines += "'" + cuisines[i] + "', "; // Thai,
            } else {
                stringCuisines += "'" + cuisines[i] + "'"; // Thai, Pizza
            }
        }
        System.out.println(stringCuisines);
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, stringCuisines);
        List<Long> idList = new ArrayList<Long>();
        while(results.next()) {
            idList.add(results.getLong("cuisine_id"));
        }
        return idList;
    }

//    public int addCuisines(Long userId, List<Long> idList){
//
//    }

//    public Profile getLocation(Long userId){
//
//    }

    @Override
    public Profile setProfile(Profile details, int userId){
        String sql = "UPDATE users SET radius = ?, zip_code = ? WHERE user_id = ? RETURNING username";
        String returnedUsername = jdbcTemplate.queryForObject(sql, String.class, details.getRadius(), details.getZipCode(), userId);
        String[] stringList = details.getCuisineType().toArray(new String[0]);
        List<Long> idList = getCuisineIds(stringList);
        sql = "INSERT INTO user_cuisine (user_id, cuisine_id) VALUES (?, ?)";
        int success = 0;
        for (Long element : idList){
            success += jdbcTemplate.queryForObject(sql, int.class, userId, element);
        }
        details.setUsername(returnedUsername);
        return details;
    }

}
