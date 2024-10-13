package com.revature;

import com.revature.DAOs.makeDAO;
import com.revature.DAOs.modelDAO;
import com.revature.models.makes;
import com.revature.models.models;
import com.revature.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Launcher {

    public static void main(String[] args) {

        try(Connection conn = ConnectionUtil.getConnection()){
            System.out.println("Connection Successful.");
        } catch(SQLException e){
            e.printStackTrace();
            System.out.println("Connection Failed.");
        }

        makeDAO maDAO = new makeDAO();
        modelDAO moDAO = new modelDAO();
        ArrayList<makes> makesArray = maDAO.getAllMakes();
        ArrayList<models> modelsArray = new ArrayList<>();

        System.out.println("---GET ALL MAKES---");
        for(makes make : makesArray){
            System.out.println(make);
        }
        System.out.println();
        makesArray.clear();

        System.out.println("---GET ALL MODELS BY MAKE---");
        modelsArray = maDAO.getModelsByMake("BMW");
        for(models model : modelsArray){
            System.out.println(model);
        }
        System.out.println();
        modelsArray.clear();

        makes testMake = new makes("test", "test", "test");
        maDAO.insertMake(testMake);

        maDAO.updateMakeCEO("test", "testWorked");

        maDAO.deleteMake("test");

        System.out.println("---GET ALL MAKES ALPHABETICALLY---");
        makesArray = maDAO.getAllMakesAlphabetical();
        for(makes make : makesArray){
            System.out.println(make);
        }
        System.out.println();

        System.out.println("---GET ALL MODELS---");
        modelsArray = moDAO.getAllModels();
        for(models model : modelsArray){
            System.out.println(model);
        }
        System.out.println();
        modelsArray.clear();

        System.out.println("---GET MAKE BY MODEL---");
        System.out.println(moDAO.getMakeByModels("Model T"));
        System.out.println();

        models testModel = new models("BMW", "test", (short)2222);
        moDAO.insertModel(testModel);

        moDAO.updateModelYear("test", (short)1111);

        moDAO.deleteModel("test");

        System.out.println("---GET ALL MODELS IN REVERSE CHRONOLOGICAL---");
        modelsArray = moDAO.getAllModelsReverseChronological();
        for(models model : modelsArray){
            System.out.println(model);
        }
        System.out.println();
        modelsArray.clear();
    }

}
