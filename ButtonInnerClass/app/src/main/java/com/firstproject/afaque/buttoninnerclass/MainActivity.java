package com.firstproject.afaque.buttoninnerclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/*
 * When to use this method ?
 * We have several buttons in a single activity
 * We want the same listener to handle all the button clicks for that activity
 */

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new ButtonHandler());
    }

    // Inner Class
    class ButtonHandler implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Log.d("LIFECYCLE", "button was clicked");

        }
    }
}

