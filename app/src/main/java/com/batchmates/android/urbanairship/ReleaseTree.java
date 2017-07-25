package com.batchmates.android.urbanairship;

import android.util.Log;

import timber.log.Timber;

/**
 * Created by Android on 7/24/2017.
 */

public class ReleaseTree extends Timber.Tree {
    private static final int MAX_LOG_LENGTH = 4000;


    @Override
    protected boolean isLoggable(String tag, int priority) {
        if(priority==Log.VERBOSE||priority==Log.DEBUG||priority==Log.INFO)
        {
            return false;
        }
        return true;
    }

    @Override
    protected void log(int priority, String tag, String message, Throwable t) {
        if(isLoggable(tag, priority))
        {
            if(message.length()<MAX_LOG_LENGTH)
            {
                if(priority== Log.ASSERT)
                {
                    Log.wtf(tag,message);
                }
                else
                {
                    Log.println(priority,tag,message);
                }
                return;
            }
        }
    }
}
