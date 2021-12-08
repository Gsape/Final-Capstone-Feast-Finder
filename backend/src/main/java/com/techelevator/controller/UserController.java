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
    @RequestMapping (path = "/profile", method = RequestMethod.GET)


    // setInitialPreferences() - client sets the zip code, radius, and cuisine preferences that are their initial default
        // may not need a DTO or model
    @RequestMapping (path = "/profile", method = RequestMethod.POST)


    // updatePreferences() - client updates their cuisine preferences
        // may not need a DTO or model
    @RequestMapping (path = "/profile", method = RequestMethod.PUT)


    // getPreferences() - client retrieves their cuisine preferences
        // may not need a DTO or model
    @RequestMapping (path = "/profile", method = RequestMethod.GET)


    // setUserFave() - client adds a new FAVE restaurant to the restaurant table
        // will need a RestaurantDTO and model
    @RequestMapping (path = "/restaurants", method = RequestMethod.POST)


    // getUserFaves() - client retrieves ALL of their FAVE restaurants
        // will need a RestaurantDTO and model
    @RequestMapping (path = "/restaurants", method = RequestMethod.GET)


    // setUserHate() - client adds a new HATED restaurant to the restaurant table
        // will need a RestaurantDTO and model
    @RequestMapping (path = "/restaurants", method = RequestMethod.POST)


    // getUserHates() - client retrieves ALL of their HATED restaurants
        // will need a RestaurantDTO and model
    @RequestMapping (path = "/restaurants", method = RequestMethod.GET)

}
