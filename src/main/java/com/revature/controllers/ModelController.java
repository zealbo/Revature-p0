package com.revature.controllers;

import com.revature.DAOs.modelDAO;
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

}
