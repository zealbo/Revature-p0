package com.revature.controllers;

import com.revature.DAOs.makeDAO;
import com.revature.models.makes;
import com.revature.models.models;
import io.javalin.http.Handler;

import java.util.ArrayList;

public class MakeController {

    //we need a role to use its methods
    makeDAO mDAO = new makeDAO();

    //this handler will handle GET requests to roles/{id}
    public Handler getMakeByName = ctx ->{

        //extract the path parameter from the HTTP request URL
        //pathParam() returns a string, we may need to parse as int
        String make_name = ctx.pathParam("make_name");

        //instantiate a models that holds the data from the specific role ID
        ArrayList<models> models = mDAO.getModelsByMake(make_name);

        //models sure the models that came back isn't null, if so, send 404 not found error
        if(models == null){
            ctx.result("Make name: " + make_name + "not found");
            ctx.status(404);
        }

        ctx.json(models);
        ctx.status(200);
    };


    //this handler will handle patch requests to roles/{id} and we'll put the new salary in the body
    public Handler updateMakeCEO = ctx -> {
        //the user will include the role id in the path parameter
        //and they'll include the new salary in the request body
        String make_name = ctx.pathParam("Name");
        String make_CEO = ctx.body();
        //NOTE: remember, we use body() for single variables and bodyAsClass() for objects

        //TODO: user input checks

        //Call the DAO, try to save the new CEO in a string
        //String newCEO = mDAO.updateMakeCEO(make_name, make_CEO);

        //ctx.result("Make: " + make_name + " CEO updated to " + newCEO);
        ctx.status(200);

    };
}
