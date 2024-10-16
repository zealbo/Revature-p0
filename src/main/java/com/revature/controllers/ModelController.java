package com.revature.controllers;

import com.revature.DAOs.modelDAO;
import com.revature.models.makes;
import com.revature.models.models;
import io.javalin.http.Handler;

import java.util.ArrayList;

//The controller layer is where HTTP requests get sent after Javalin directs them from main()
//it is in this layer that JSON comes in and gets translated to java and vice versa
//We'll be taking in HTTP requests from the client, and sending back HTTP responses
//The controllers job is to process HTTP requests and respond to them appropriately
public class ModelController {

    //we need an DAO to use the jdbc methods (get all, insert, etc)
    modelDAO mDAO = new modelDAO();

    //this handler will handle get requests to employees
    public Handler getModelsHandler = ctx -> {

        //populate an arraylist of models objects from the DAO!
        ArrayList<models> models = mDAO.getAllModels();

        //Problem: we cant send plain java in an http response - we need to use JSON

        //Solution: we can use the ctx.json() method to convert this arraylist to JSON
        //note: this also returns the object to the client once the code block completes. convenient!
        ctx.json(models);

        //we can also set the status code ctx.status()
        ctx.status(200); //OK

    };

    public Handler getMakeByModel = ctx -> {

        //extract the path parameter for http request url
        String model = ctx.pathParam("model");
        makes make = mDAO.getMakeByModels(model);
        ctx.status(200);
        ctx.json(make);

    };

    public Handler insertModel = ctx -> {
        //we have json coming in (we're sending a models object through postman)
        //we need to convert that json to a java class object before we can send it to the DAO
        //we can use ctx.bodyAsClass() to do this (HTTP request -> java object)
        models newModel = ctx.bodyAsClass(models.class);
        //Let's show off some error handling - make sure models has a
        //.isBlank() checks if the string is empty or whitespace
        if(newModel.getModel_name() == null || newModel.getModel_name().isEmpty()){
            ctx.result("Model name is required!!");
            ctx.status(400);
        }else if(newModel.getModel_year() == 0){
            ctx.result("Model year is required!!");
            ctx.status(400);
        }

        //if the if's don't trigger, then the inputted model is good!
        models insertedModel = mDAO.insertModel(newModel);

        ctx.status(200);
        ctx.json(insertedModel);
    };

    public Handler updateModelYear = ctx -> {

        String model = ctx.pathParam("model");
        short newYear = Short.parseShort(ctx.body());
        short updatedYear = mDAO.updateModelYear(model, newYear);
        ctx.result("Model name: " + model + " year updated to: " + newYear);
        ctx.status(200);

    };

    public Handler deleteModel = ctx -> {
        String model = ctx.pathParam("model");
        mDAO.deleteModel(model);
        ctx.result("The model: " + model + " was deleted");
        ctx.status(200);
    };

    public Handler getModelsChrono = ctx -> {
        ArrayList<models> models = mDAO.getAllModelsReverseChronological();
        ctx.json(models);
        ctx.status(200);
    };

}
