package com.firstproject.afaque.clicklistenertutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/*
 * 1. Tell android that you're interested in listening to the button click implement OnClickListener
 * 2. Bring XML button inside Java
 * 3. Tell your Java button who is responding when it is clicked
 * 4. What should happen when the button is clicked
*/

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);

        // Object of MainActivity is the one responding when the button is clicked It
        // will respond through the onClick method. onClickListener requires and object.
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.button1)
            Log.d("LIFECYCLE", "sensor");
        else if(view.getId() == R.id.button2)
            Log.d("LIFECYCLE", "location");
    }
}
