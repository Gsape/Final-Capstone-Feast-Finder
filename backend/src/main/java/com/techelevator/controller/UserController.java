package com.techelevator.controller;

import javax.security.auth.login.AccountNotFoundException;
import javax.validation.Valid;

import com.techelevator.dao.ProfileDao;
import com.techelevator.dao.RestaurantDao;
import com.techelevator.model.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techelevator.dao.UserDao;
import com.techelevator.security.jwt.JWTFilter;
import com.techelevator.security.jwt.TokenProvider;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin

public class
UserController {

    private UserDao userDao;
    private RestaurantDao restaurantDao;
    private ProfileDao profileDao;

    public UserController(UserDao userDao, RestaurantDao restaurantDao, ProfileDao profileDao){
        this.userDao = userDao;
        this.restaurantDao = restaurantDao;
        this.profileDao = profileDao;
    };


    // getProfile() - client retrieves the zipcode and radius of their default/home location
    @RequestMapping(path = "/profile", method = RequestMethod.GET)
    public Profile getProfile(Principal username){
        if (username == null){
            System.out.println("username is null"); // needs to throw an exception instead
        }
        String userName = username.getName();
        int userId = userDao.findIdByUsername(userName);
        Profile profile = profileDao.getLocation(userId); //this
        profile.setCuisineType(profileDao.getCuisines(userId));
        return profile;
    }

    // setInitialPreferences() - client sets the zip code, radius, and cuisine preferences that are their initial default
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/profile", method = RequestMethod.POST)
    public Profile setInitialPreferences(Principal username, @RequestBody Profile profile) {
        if (username == null) {
            System.out.println("username is null");
        }
        String userName = username.getName();
        int userId = userDao.findIdByUsername(userName);
        return profileDao.setProfile(profile, userId);
    }

    // updatePreferences() - client updates their cuisine preferences or home
    @RequestMapping (path = "/profile", method = RequestMethod.PUT)
    public Profile updatePreferences(Principal username, @RequestBody Profile profile){
        if (username == null){
            System.out.println("username is null"); // needs to throw an exception instead
        }
        String userName = username.getName();
        int userId = userDao.findIdByUsername(userName);
        return profileDao.updateProfile(profile, userId);
    }

    // setUserFave() - client adds a new FAVE restaurant to the restaurant table
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping (path = "/restaurants/love", method = RequestMethod.POST)
    public String setUserFave(Principal username, @RequestBody RestaurantDTO restaurant){
        if (username == null){
            System.out.println("username is null"); // needs to throw an exception instead
        }
        String userName = username.getName();
        int userId = userDao.findIdByUsername(userName);
        String success = restaurantDao.addUserRestaurant(userId, restaurant);
        if (success != null){
            return "Success!";
        } else {
            return "Operation failed.";
        }
    }

    // getUserFaves() - client retrieves ALL of their FAVE restaurants
    @RequestMapping (path = "/restaurants/love", method = RequestMethod.GET)
    public List<String> getUserFaves(Principal username){
        List<String> listy = new ArrayList<>();
        if (username == null){
            System.out.println("username is null"); // needs to throw an exception instead
        }
        String userName = username.getName();
        int userId = userDao.findIdByUsername(userName);
        listy = restaurantDao.getPreferences(userId, true);
        return listy;
    }

    // setUserHate() - client adds a new HATED restaurant to the restaurant table
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping (path = "/restaurants/hate", method = RequestMethod.POST)
    public String setUserHate(Principal username, @RequestBody RestaurantDTO restaurant){
        if (username == null){
            System.out.println("username is null"); // needs to throw an exception instead
        }
        String userName = username.getName();
        int userId = userDao.findIdByUsername(userName);
        String success = restaurantDao.addUserRestaurant(userId, restaurant);
        if (success != null){
            return "Success!";
        } else {
            return "Operation failed.";
        }
    }

    // getUserHates() - client retrieves ALL of their HATED restaurants
    @RequestMapping (path = "/restaurants/hate", method = RequestMethod.GET)
    public List<String> getUserHates(Principal username){
        List<String> listy = new ArrayList<>();
        if (username == null){
            System.out.println("username is null"); // needs to throw an exception instead
        }
        String userName = username.getName();
        int userId = userDao.findIdByUsername(userName);
        listy = restaurantDao.getPreferences(userId, false);
        return listy;
    }
}
