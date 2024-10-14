package com.revature;

import com.revature.controllers.ModelController;
import io.javalin.Javalin;

public class LauncherNEW {

    public static void main(String[] args) {

        //typical javalin setup syntax
        var app = Javalin.create().start(7000);

        //we need create() to begin the instantiation of our javalin object
        //we need start() to actually start our Javalin app or a port of our choosing
        //you can choose any port, but make sure it's a port that isn't being used

        //a very basic callable resource just for fun
        //we sent a response from launcher here, but responses will really be in the controllers
        app.get("/", ctx -> ctx.result("Hello Javali and Postman"));

        //TODO: We need to instantiate controllers
        ModelController mc = new ModelController();

        //Get All models
        app.get("/models", mc.getModelsHandler);

    }

}
