package com.techelevator.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class YelpKey {
    private String key;
    File yelpFile = new File("src/main/resources/yelp");

    public YelpKey() {
        try (Scanner fileReader = new Scanner(yelpFile)) {
            while (fileReader.hasNext()){
                key = fileReader.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist.");
        }
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
