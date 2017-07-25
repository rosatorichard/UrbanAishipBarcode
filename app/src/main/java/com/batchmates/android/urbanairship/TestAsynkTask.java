package com.batchmates.android.urbanairship;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Android on 7/24/2017.
 */

public class TestAsynkTask extends AsyncTask<String,Integer,String> {
    private static final String TAG = "Test";


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {

        for (int i = 0; i <10 ; i++) {

            try {
                Thread.sleep(1000);
                Log.d(TAG, "doInBackground: "+i);
                
                publishProgress(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        return null;
    }


    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

        System.out.println(Thread.currentThread());
    }


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        System.out.println("in Post Exec"+Thread.currentThread());
    }
}
