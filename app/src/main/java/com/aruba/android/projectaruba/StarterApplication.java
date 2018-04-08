package com.aruba.android.projectaruba;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;

/**
 * Created by HJWilliams on 4/6/2018.
 */

public class StarterApplication extends Application {

    public void onCreate() {
        super.onCreate();

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        // Add your initialization code here
        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                .applicationId("1554fe6d60bfe31c9fbe758b751df411c9a2ff6e")
                .clientKey("dc465f0d7312ed5e9b731d8a04c7ddf9171edda1")
                .server("http://18.219.250.187:80/parse/")
                .build());

        //ParseUser.enableAutomaticUser();

        ParseACL defaultACL = new ParseACL();
        defaultACL.setPublicReadAccess(true);
        defaultACL.setPublicWriteAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);
    }
}
