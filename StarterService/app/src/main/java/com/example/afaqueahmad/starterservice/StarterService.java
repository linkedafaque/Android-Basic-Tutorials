package com.example.afaqueahmad.starterservice;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class StarterService extends Service {

    /**
     * For services as well, similar to activity there are lifecycle methods
     * 1. onCreate() method : start/init resources & then call onStartCommand() method
     * 2. onStartCommand() : Service starts and can run in background indefinitely
     *                       All the work is done in onStartCommand() method
     * 3. In the lifecycle of  Services, onCreate is called only once, If we start
     *    the service again, it will call onStartCommand() directly
     * */

    Handler handler = new Handler(getMainLooper());

    @Override
    public void onCreate() {
        super.onCreate();
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getBaseContext(), "Service is created", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getBaseContext(), "Service is started", Toast.LENGTH_LONG).show();
            }
        });
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getBaseContext(), "Service is destroyed", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
