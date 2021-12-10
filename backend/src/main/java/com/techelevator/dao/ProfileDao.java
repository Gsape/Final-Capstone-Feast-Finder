package com.techelevator.dao;

import com.techelevator.model.Profile;
import com.techelevator.model.ProfileDTO;

import java.util.List;

public interface ProfileDao {

    List<Long> getCuisineIds(String[] cuisines);

    String addCuisines(int userId, List<Long> idList);

//    Profile getLocation(int userId);

    Profile setProfile(Profile profile, int userId);
}
