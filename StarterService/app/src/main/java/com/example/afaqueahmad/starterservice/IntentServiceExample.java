package com.example.afaqueahmad.starterservice;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

public class IntentServiceExample extends IntentService {


    /**
     * Whenever the work is over, system stops the service automatically.
     */
    public IntentServiceExample(String name) {
        //Name for the worker thread
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d("ABC", "handling intent");
    }
}
