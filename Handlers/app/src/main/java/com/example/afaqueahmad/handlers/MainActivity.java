package com.example.afaqueahmad.handlers;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    Thread thread;
    Handler handler;
    ProgressBar progressBar;

    @SuppressLint("HandlerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        thread = new Thread(new Mythread());
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                progressBar.setProgress(msg.arg1);
            }
        };
        thread.start();

        //Alternative way of running threads
        /*Thread thread = new Thread() {
            @Override
            public void run() {
                //Do Something;
            }
        };
        thread.start();*/
    }

    class Mythread implements Runnable {
        // The code here will run on a separate thread
        @Override
        public void run() {
            for(int i = 0; i < 10000; i++) {
                Message message = Message.obtain();
                message.arg1 = i;
                handler.sendMessage(message);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

/*
class MyThreadNew extends Thread {
    //We need this thread to be capable of having its own message queue and processing its messages
    //We should have a handler
    Handler handler;
    public MyThreadNew() {

    }

    @Override
    public void run() {
        //Makes this thread into something which is capable of having & handler a message queue
        //Since looper is declared here, it is responsible for handling messages that go to the background thread
        //If declared in onCreate(), it handles the messages in the main thread
        Looper.prepare();

        //Run the message queue and process
        Looper.loop();
    }
}
*/
