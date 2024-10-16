package com.revature;

import com.revature.controllers.MakeController;
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
        app.get("/", ctx -> ctx.result("Hello Javalin and Postman"));

        //We need to instantiate controllers
        ModelController moCon = new ModelController();
        MakeController maCon = new MakeController();

        //Get All models
        app.get("/models", moCon.getModelsHandler);

        //{model} is a PATH PARAMETER, the model we're looking up is the variable
        app.get("/models/{model}", moCon.getMakeByModel);

        //insert model
        //app.post is the javalin handler method that takes in post requests
        //why are they allowed to have 2 handlers that end in /models
        app.post("/models", moCon.insertModel);

        app.patch("/models/{model}", moCon.updateModelYear);

        app.delete("/models/{model}", moCon.deleteModel);

        app.get("/chrono", moCon.getModelsChrono);

        //get Make by name
        app.get("/makes/{make_name}", maCon.getMakeByName);

        //update make CEO //TODO
    }

}
