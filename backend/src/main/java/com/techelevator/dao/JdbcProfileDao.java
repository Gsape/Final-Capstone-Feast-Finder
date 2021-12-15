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
        String sout = "";
        while(results.next()) {
            sout = results.getString("cuisine_id");
//            idList.add(results.getLong("cuisine_id"));
        }
        System.out.println(sout);
        return idList;
    }

    @Override
    public String addCuisines(int userId, List<Long> idList){
        int successGoal = idList.size();
        String sql = "INSERT INTO user_cuisine (user_id, cuisine_id) VALUES (?, ?)";
        int results = 0;
        for (Long element : idList){
            results += jdbcTemplate.queryForObject(sql, int.class, userId, element);
        }
        if (successGoal == results){
            return "Success!";
        } else {
            return "Operation failed.";
        }
    }

    @Override
    public Profile getLocation(int userId){
        Profile returnThis = new Profile();
        String sql = "SELECT * FROM users WHERE user_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, userId);
        if (result.next()){
            returnThis.setRadius(result.getInt("radius"));
            returnThis.setZipCode(result.getInt("zip_code"));
            returnThis.setUsername(result.getString("username"));
        }
        return returnThis;
    }

    @Override
    public Profile setProfile(Profile details, int userId){
        String sql = "DELETE FROM user_cuisine WHERE user_id = ?";
        int results = jdbcTemplate.update(sql, userId);
        sql = "UPDATE users SET radius = ?, zip_code = ? WHERE user_id = ? RETURNING username";
        String returnedUsername = jdbcTemplate.queryForObject(sql, String.class, details.getRadius(), details.getZipCode(), userId);
        String[] stringList = details.getCuisineType().toArray(new String[0]);
        sql = "INSERT INTO user_cuisine (user_id, cuisine) VALUES (?, ?)";
        for (String element : stringList){
            jdbcTemplate.update(sql, userId, element);
        }
        details.setUsername(returnedUsername);
        return details;
    }

    @Override
    public List<String> getCuisines(int userId){
        String sql = "SELECT cuisine FROM user_cuisine WHERE user_id = ?";
        List<String> preferences = new ArrayList<>();
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()){
            preferences.add(results.getString("cuisine"));
        }
        return preferences;
    }

    @Override
    public Profile updateProfile(Profile details, int userId){
        String sql = "DELETE FROM user_cuisine WHERE user_id = ?";
        int results = jdbcTemplate.update(sql, userId);
        Profile newProfile = setProfile(details, userId);
        return newProfile;
    }
}
