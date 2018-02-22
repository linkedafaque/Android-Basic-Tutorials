package com.example.afaqueahmad.implicitintents;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void process(View view) {

        //chooser is used to see if there is no application
        //which supports the above activity,hence stop crashing

        Intent intent = null, chooser = null;

        if(view.getId() == R.id.launchMap) {
            // Viewing action
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo: 19.076, 72.8777"));
            //fail proof way of doing things
            //could have also done startActivity(intent)
            chooser = intent.createChooser(intent, "Launch Maps");
            startActivity(chooser);
        }
        else if(view.getId() == R.id.launchMarket) {
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=com.caffeine.hydraulics&hl=en"));
            chooser = intent.createChooser(intent, "Launch Market");
            startActivity(chooser);
        }
        else if(view.getId() == R.id.sendEmail) {
            intent = new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"));
            String[] to = {"linkedafaque@gmail.com", "omairaparveen27@gmail.com"};
            intent.putExtra(Intent.EXTRA_EMAIL, to);
            intent.putExtra(Intent.EXTRA_SUBJECT, "Sent From Afaque With Love");
            intent.putExtra(Intent.EXTRA_TEXT, "Hey, this is my first email from an android app made by me!");
            intent.setType("message/rfc822"); // MIME Type
            chooser = intent.createChooser(intent, "Send Email");
            startActivity(chooser);
        }
        else if(view.getId() == R.id.sendImage) {
            Uri image = Uri.parse("android.resource://com.example.afaqueahmad.implicitintents/drawable/" + R.drawable.ic_launcher_background);
            intent = new Intent(Intent.ACTION_SEND);
            intent.setType("image/*");
            intent.putExtra(Intent.EXTRA_STREAM, image);
            intent.putExtra(Intent.EXTRA_TEXT, "Hey, I have attached this image!");
            chooser = intent.createChooser(intent, "Send Image");
            startActivity(chooser);
        }
        else if(view.getId() == R.id.sendImages) {
            //Returns a file object containing all the pictures in the external storage
            File pictures = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            String[] listOfPictures = pictures.list();
            Uri uri = null;
            ArrayList<Uri> arrayList = new ArrayList<>();
            for(String picture: listOfPictures) {
                uri = Uri.parse("file://" + pictures.toString() + "/" + picture);
                arrayList.add(uri);
                //L.s(this, picture);
            }
            intent = new Intent(Intent.ACTION_SEND_MULTIPLE);
            intent.setType("image/*");
            intent.putExtra(Intent.EXTRA_STREAM, arrayList);
            chooser = Intent.createChooser(intent, "Send Multiple Images");
            startActivity(chooser);
        }
    }
}
