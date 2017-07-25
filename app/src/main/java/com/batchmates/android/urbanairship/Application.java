package com.batchmates.android.urbanairship;

import android.content.res.Configuration;

import com.squareup.leakcanary.LeakCanary;
import com.urbanairship.*;

import timber.log.Timber;

/**
 * Created by Android on 7/24/2017.
 */

public class Application extends android.app.Application {

    // Called when the application is starting, before any other application objects have been created.
    // Overriding this method is totally optional!
    @Override
    public void onCreate() {
        super.onCreate();
        UAirship.takeOff(this);
        UAirship.shared().getPushManager().setUserNotificationsEnabled(true);



        if(BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree() {

                @Override
                protected String createStackElementTag(StackTraceElement element) {
                    return super.createStackElementTag(element) + " : " + element.getLineNumber();
                }
            });
        }
        else
        {
            Timber.plant(new ReleaseTree());
        }
        // Required initialization logic here!

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        // Normal app init code...

    }

    // Called by the system when the device configuration changes while your component is running.
    // Overriding this method is totally optional!
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    // This is called when the overall system is running low on memory,
    // and would like actively running processes to tighten their belts.
    // Overriding this method is totally optional!
    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

}
