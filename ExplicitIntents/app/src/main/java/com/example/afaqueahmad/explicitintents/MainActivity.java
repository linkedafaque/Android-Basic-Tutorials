package com.example.afaqueahmad.explicitintents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = (Button) findViewById(R.id.button1);
    }

    public void doSomething(View view) {
        // Intent i = new Intent(this, Main2Activity.class);
        // startActivity(i);
        Intent i = new Intent();
        i.setClassName("com.example.afaqueahmad.explicitintents", "com.example.afaqueahmad.explicitintents.Main2Activity");
        startActivity(i);
    }
}
