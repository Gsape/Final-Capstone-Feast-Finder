package com.techelevator.controller;

import javax.security.auth.login.AccountNotFoundException;
import javax.validation.Valid;

import com.techelevator.dao.ProfileDao;
import com.techelevator.dao.RestaurantDao;
import com.techelevator.model.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import java.util.List;

@RestController
@CrossOrigin

public class UserController {

    private UserDao userDao;
    private RestaurantDao restaurantDao;
    private ProfileDao profileDao;

    public UserController(UserDao userDao, RestaurantDao restaurantDao, ProfileDao profileDao){
        this.userDao = userDao;
        this.restaurantDao = restaurantDao;
        this.profileDao = profileDao;
    };

    // getHome() - client retrieves the zipcode and radius of their default/home location
        // will need a HomeDTO and Home model
//    @RequestMapping(path = "/profile", method = RequestMethod.GET)
//    public Profile getHome(Principal username){
//        if (username == null){
//            System.out.println("username is null"); // needs to throw an exception instead
//        }
//        String userName = username.getName();
//        int userId = userDao.findIdByUsername(userName);
//
//        profileDao.getLocation(userId); //this
//        Profile hellyeah = new Profile();
//        return hellyeah;
//
//    }

    // setInitialPreferences() - client sets the zip code, radius, and cuisine preferences that are their initial default
        // may not need a DTO or model
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

//    // updatePreferences() - client updates their cuisine preferences
//        // may not need a DTO or model
//    @RequestMapping (path = "/profile", method = RequestMethod.PUT)
//    public int updatePreferences(Principal username, @RequestBody String[] cuisines){
//        if (username == null){
//            System.out.println("username is null"); // needs to throw an exception instead
//        }
//        String userName = username.getName();
//        int userId = userDao.findIdByUsername(userName);
//        List<Long> idList = profileDao.getCuisineIds(cuisines);
//        return profileDao.addCuisines(userId, idList);
//    }

//    // getPreferences() - client retrieves their cuisine preferences
//        // may not need a DTO or model
//    @RequestMapping (path = "/profile", method = RequestMethod.GET)
//
//
//
//    // setUserFave() - client adds a new FAVE restaurant to the restaurant table
//        // will need a RestaurantDTO and model
//    @RequestMapping (path = "/restaurants", method = RequestMethod.POST)
//    public Restaurant setUserFave(Principal username, @RequestBody RestaurantDTO restaurant){
//        if (username == null){
//            System.out.println("username is null"); // needs to throw an exception instead
//        }
//        String userName = username.getName();
//        Long userId = userDao.findIdByUsername(userName);
//        if (restaurantDao.checkIfRestaurantExists(restaurant)){
//            return restaurantDao.addUserFave(userId, restaurant);
//        } else {
//            Long newId = restaurantDao.addNewRestaurant(restaurant);
//            return restaurantDao.addUserFave(userId, newId);
//        }
//    }
//
//    // getUserFaves() - client retrieves ALL of their FAVE restaurants
//        // will need a RestaurantDTO and model
//    @RequestMapping (path = "/restaurants", method = RequestMethod.GET)
//
//
//    // setUserHate() - client adds a new HATED restaurant to the restaurant table
//        // will need a RestaurantDTO and model
//    @RequestMapping (path = "/restaurants", method = RequestMethod.POST)
//
//
//    // getUserHates() - client retrieves ALL of their HATED restaurants
//        // will need a RestaurantDTO and model
//    @RequestMapping (path = "/restaurants", method = RequestMethod.GET)

}
