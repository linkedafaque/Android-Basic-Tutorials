package com.example.afaqueahmad.implicitintents;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by afaqueahmad on 22/2/18.
 */

public class L {
    public static void m(String message) {
        Log.d("LIFECYCLE", message);
    }
    public static void s(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
