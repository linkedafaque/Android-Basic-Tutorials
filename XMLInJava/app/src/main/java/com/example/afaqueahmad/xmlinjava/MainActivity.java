package com.example.afaqueahmad.xmlinjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout ll;
    Button b;
    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ll = new LinearLayout(this);
        b = new Button(this);
        t = new TextView(this);

        LinearLayout.LayoutParams dimensions = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        ll.setLayoutParams(dimensions);

        LinearLayout.LayoutParams viewDimensions = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        b.setLayoutParams(viewDimensions);
        t.setLayoutParams(viewDimensions);

        ll.setOrientation(LinearLayout.VERTICAL);
        t.setText("Hello World");
        b.setText("Click Here");

        ll.addView(t);
        ll.addView(b);

        //Telling android that the appearance is contained inside the object ll
        setContentView(ll);
    }
}
