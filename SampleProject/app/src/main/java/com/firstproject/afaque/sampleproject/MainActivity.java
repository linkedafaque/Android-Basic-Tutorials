package com.firstproject.afaque.sampleproject;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("LIFECYCLE", "onCreate() was called");
    }

    @Override
    protected void onResume() {
        //Takes care of some default behaviours
        super.onResume();
        Log.d("LIFECYCLE", "onResume() was called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LIFECYCLE", "onStart() was called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LIFECYCLE", "onStop() was called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LIFECYCLE", "onRestart() was called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LIFECYCLE", "onDestroy() was called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LIFECYCLE", "onPause() was called");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d("LIFECYCLE","orientation changed");
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
            Log.d("LIFECYCLE", "landscape mode");
        else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
            Log.d("LIFECYCLE", "portrait mode");
    }

    public void doSomething(View view) {
        // R stands for resources
        if(view.getId() == R.id.button1)
            Log.d("LIFECYCLE", "Button 1 was clicked");
        else if(view.getId() == R.id.button2)
            Log.d("LIFECYCLE", "Button 2 was clicked");
    }
}
