package com.afaque.keepsafe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
            Toast.makeText(MainActivity.this, "Volume Down Pressed", Toast.LENGTH_LONG).show();
        }
        return true;
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        super.onKeyUp(keyCode, event);
        if(keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
            Toast.makeText(MainActivity.this, "Volume Up Pressed", Toast.LENGTH_LONG).show();
        }
        return true;
    }
}
