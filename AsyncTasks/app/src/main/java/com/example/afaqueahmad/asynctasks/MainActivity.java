package com.example.afaqueahmad.asynctasks;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView mainView;
    private String texts[] = {  "abcd","abcd","abcd","abcd","abcd","abcd","abcd","abcd","abcd",
                                "abcd","abcd","abcd","abcd","abcd","abcd","abcd","abcd","abcd",
                                "abcd","abcd","abcd","abcd","abcd","abcd","abcd","abcd","abcd",
                                "abcd","abcd","abcd","abcd","abcd","abcd","abcd","abcd","abcd",
                                "abcd","abcd","abcd","abcd","abcd","abcd","abcd","abcd","abcd",
                                "abcd","abcd","abcd","abcd","abcd","abcd","abcd","abcd","abcd",
                                "abcd","abcd","abcd","abcd","abcd","abcd","abcd","abcd","abcd" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_PROGRESS);
        setContentView(R.layout.activity_main);
        mainView = (ListView) findViewById(R.id.listView);
        mainView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<String>()));
        new MyClass().execute();
    }

    /**
    * Creating Async task inside the class so that we are able to access
    * the listView and the Strings list
    */
    class MyClass extends AsyncTask<Void, String, Void> {

        /**
         * 1st Parameter - doInBackground()
         * 2nd Parameter - onProgressUpdate()
         * 3rd Parameter - Result of doInBackground()
         * */

        private ArrayAdapter<String> adapter;
        private int counter = 0;

        @Override
        protected void onPreExecute() {
            adapter = (ArrayAdapter<String>) mainView.getAdapter();
            setProgressBarIndeterminate(false);
            setProgressBarVisibility(true);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            for(String item: texts) {
                publishProgress(item);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            adapter.add(values[0]);
            ++counter;
            setProgress((int) (((double)counter/texts.length) * 10000));
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Toast.makeText(MainActivity.this, "All Items were added successfully", Toast.LENGTH_LONG);
            setProgressBarVisibility(false);
        }
    }
}
