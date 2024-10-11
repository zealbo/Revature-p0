package com.revature.DAOs;

import com.revature.models.makes;
import com.revature.models.models;

public interface modelDAOInterface {

    //Select all items from the items table
    void getAllModels();
    //Select make by model
    void getMakeByModels(String model);
    //Insert new model
    makes insertModel(models m);
    //update model
    void updateModelYear(String model, String model_year);
    //delete model
    void deleteModel(String model);
    //cool functionality
    void getAllModelsChronological();

}
