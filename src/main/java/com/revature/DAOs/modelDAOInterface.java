package com.revature.DAOs;

import com.revature.models.makes;
import com.revature.models.models;

import java.util.ArrayList;

public interface modelDAOInterface {

    //Select all items from the items table
    ArrayList<models> getAllModels();
    //Select make by model
    makes getMakeByModels(String model);
    //Insert new model
    models insertModel(models m);
    //update model
    void updateModelYear(String model, short model_year);
    //delete model
    void deleteModel(String model);
    //cool functionality
    ArrayList<models> getAllModelsReverseChronological();

}
