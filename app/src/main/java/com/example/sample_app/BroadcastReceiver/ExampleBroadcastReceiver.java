package com.example.sample_app.BroadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class ExampleBroadcastReceiver extends BroadcastReceiver {
    public static final String MY_CUSTOM_ACTION = "com.example.sample_app.EXAMPLE_ACTION";
    public static final String MY_CUSTOM_STRING_EXTRA = "com.example.sample_app.EXTRA_TEXT";
    @Override
    public void onReceive(Context context, Intent intent) {
        /*if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {

            Toast.makeText(context, "BOOT COMPLETED!", Toast.LENGTH_SHORT).show();

        }*/
        if (MY_CUSTOM_ACTION.equals(intent.getAction())) {
            String receivedText = intent.getStringExtra(MY_CUSTOM_STRING_EXTRA);
            Toast.makeText(context, receivedText, Toast.LENGTH_SHORT).show();
        }
    }
}
