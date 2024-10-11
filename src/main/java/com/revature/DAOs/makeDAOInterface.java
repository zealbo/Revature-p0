package com.revature.DAOs;

import com.revature.models.makes;

public interface makeDAOInterface {
    //Select all items from the items table
    void getAllMakes();
    //Select all models by make
    void getModelsByMake(String make);
    //Insert new make
    makes insertMake(makes m);
    //update make
    void updateMakeCEO(String make, String make_CEO);
    //delete make
    void deleteMake(String make);
    //cool functionality
    void getAllMakesAlphabetical();
}
