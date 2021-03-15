package com.codepath.simpleinstagram;

import android.app.Application;


import com.parse.BuildConfig;
import com.parse.Parse;
import com.parse.ParseObject;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // Register Parse models
        ParseObject.registerSubclass(Post.class);

        // set applicationId, and server server based on the values in the back4app settings.
        // any network interceptors must be added with the Configuration Builder given this syntax
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("PJS8FN8y7qXw29KPKT55s1jyUUrqaxkMpeOMn90L") // should correspond to Application Id env variable
                .clientKey("0zl0W0o5nssOEUqG81omhLIUQg0gItj8ljJAGDX9")  // should correspond to Client key env variable"
                .server("https://parseapi.back4app.com")
                .build()
        );
    }

}
