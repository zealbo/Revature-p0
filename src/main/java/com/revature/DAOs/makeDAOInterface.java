package com.revature.DAOs;

import com.revature.models.makes;
import com.revature.models.models;

import java.util.ArrayList;

public interface makeDAOInterface {
    //Select all items from the items table
    ArrayList<makes> getAllMakes();
    //Select all models by make
    ArrayList<models> getModelsByMake(String make);
    //Insert new make
    makes insertMake(makes m);
    //update make
    void updateMakeCEO(String make, String make_CEO);
    //delete make
    void deleteMake(String make);
    //cool functionality
    ArrayList<makes> getAllMakesAlphabetical();
}
