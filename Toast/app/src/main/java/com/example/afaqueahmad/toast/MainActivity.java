package com.example.afaqueahmad.toast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToast(View view) {
        //static method makeText Allows to make and initialize toasts
        Toast toast = Toast.makeText(this, "Hello, Testing This Toast!", Toast.LENGTH_LONG);
        toast.show();
        //control toast position on the screen: setGravity
        //toast.setGravity(Gravity.LEFT, 0,0);
        toast.setGravity(Gravity.CENTER, 0, 0);
        //toast.setGravity(Gravity.RIGHT, 0,0);
        //toast.setGravity(Gravity.BOTTOM | Gravity.RIGHT, 0,0);
    }
}