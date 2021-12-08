package com.techelevator.controller;

import javax.security.auth.login.AccountNotFoundException;
import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techelevator.dao.UserDao;
import com.techelevator.model.LoginDTO;
import com.techelevator.model.RegisterUserDTO;
import com.techelevator.model.User;
import com.techelevator.model.UserAlreadyExistsException;
import com.techelevator.security.jwt.JWTFilter;
import com.techelevator.security.jwt.TokenProvider;

@RestController
@CrossOrigin

public class UserController {

    private UserDao userDao;

    public UserController(){};

    // getHome() - client retrieves the zipcode and radius of their default/home location
        // will need a HomeDTO and Home model
//    @RequestMApping(path = "/profile", method = RequestMethod.GET)
//    public Profile getHome(Principal username){
//        String username = username.getUsername();
//        int userId = userDAO.findIdByUsername(username);
//
//        return profileDao.getLocation(userId); //this
//    }

    // setInitialPreferences() - client sets the zip code, radius, and cuisine preferences that are their initial default
        // may not need a DTO or model


    // updatePreferences() - client updates their cuisine preferences
        // may not need a DTO or model


    // getPreferences() - client retrieves their cuisine preferences
        // may not need a DTO or model


    // setUserFave() - client adds a new FAVE restaurant to the restaurant table
        // will need a RestaurantDTO and model


    // getUserFaves() - client retrieves ALL of their FAVE restaurants
        // will need a RestaurantDTO and model


    // setUserHate() - client adds a new HATED restaurant to the restaurant table
        // will need a RestaurantDTO and model


    // getUserHates() - client retrieves ALL of their HATED restaurants
        // will need a RestaurantDTO and model


}
