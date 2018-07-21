package com.example.afaqueahmad.starterservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startService(View view) {
        Intent intent = new Intent(this, StarterService.class);
        startService(intent);
    }

    public void endService(View view) {
        Intent intent = new Intent(this, StarterService.class);
        stopService(intent);
    }
}
