package com.revature;

import io.javalin.Javalin;

public class LauncherNEW {

    public static void main(String[] args) {

        //typical javalin setup syntax
        var app = Javalin.create().start(7000);

        //we need create() to begin the instantiation of our javalin object
        //we need start() to actually start our Javalin app or a port of our choosing
        //you can choose any port, but make sure it's a port that isn't being used

        //a very basic callable resource just for fun
        app.get("/", ctx -> ctx.result("Hello Javali and Postman"));


    }

}
